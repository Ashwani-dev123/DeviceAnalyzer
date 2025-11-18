package com.example.githhubdemo.deviceinfo.data.provider

import android.os.Build
import android.util.Log
import com.example.githhubdemo.deviceinfo.data.model.CPULoad
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo
import com.example.githhubdemo.deviceinfo.utils.Settings
import com.example.githhubdemo.deviceinfo.utils.cacheHumanReadable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File
import java.io.FileFilter
import java.io.RandomAccessFile
import java.util.regex.Pattern

class CpuDataProvider(
    private val settings: Settings
) {

    /** Instead of JNI, fetch CPU name from /proc/cpuinfo or Build fields */
    private fun getCpuName(): String {
        return try {
            val reader = File("/proc/cpuinfo").bufferedReader()
            val cpuLine = reader.lineSequence().firstOrNull { it.startsWith("Hardware") || it.startsWith("model name") }
            reader.close()
            cpuLine?.substringAfter(":")?.trim()
                ?: Build.HARDWARE.ifEmpty { Build.BOARD.ifEmpty { "Unknown CPU" } }
        } catch (e: Exception) {
            "Unknown CPU"
        }
    }

    /** Return first ABI */
    private fun getAbi(): String = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown"

    /** Check for ARM NEON via system property or ABI */
    private fun hasArmNeon(): Boolean {
        val abi = getAbi().lowercase()
        return abi.contains("arm") || abi.contains("neon") || abi.contains("armeabi") || abi.contains("arm64")
    }

    /** Cache info placeholders (cannot be reliably accessed without root) */
    private fun getL1dCaches(): IntArray? = intArrayOf(32 * 1024) // 32 KB
    private fun getL1iCaches(): IntArray? = intArrayOf(32 * 1024)
    private fun getL2Caches(): IntArray? = intArrayOf(256 * 1024)
    private fun getL3Caches(): IntArray? = intArrayOf(2 * 1024 * 1024)
    private fun getL4Caches(): IntArray? = null

    /** Count CPU cores by checking /sys/devices/system/cpu/cpu[0-9]+ */
    private fun getNumberOfCores(): Int {
        return try {
            File(CPU_INFO_DIRECTORY).listFiles { file ->
                Pattern.matches("cpu[0-9]+", file.name)
            }?.size ?: Runtime.getRuntime().availableProcessors()
        } catch (e: Exception) {
            Runtime.getRuntime().availableProcessors()
        }
    }

    /** Current frequency in MHz */
    private fun getCurrentFreq(coreNumber: Int): Long {
        val path = "${CPU_INFO_DIRECTORY}cpu$coreNumber/cpufreq/scaling_cur_freq"
        return try {
            RandomAccessFile(path, "r").use { it.readLine().toLong() / 1000 }
        } catch (e: Exception) {
            -1
        }
    }

    /** Min/max frequency per core in MHz */
    private fun getMinMaxFreq(coreNumber: Int): Pair<Long, Long> {
        val minPath = "${CPU_INFO_DIRECTORY}cpu$coreNumber/cpufreq/cpuinfo_min_freq"
        val maxPath = "${CPU_INFO_DIRECTORY}cpu$coreNumber/cpufreq/cpuinfo_max_freq"
        return try {
            val minMhz = RandomAccessFile(minPath, "r").use { it.readLine().toLong() / 1000 }
            val maxMhz = RandomAccessFile(maxPath, "r").use { it.readLine().toLong() / 1000 }
            Pair(minMhz, maxMhz)
        } catch (e: Exception) {
            Pair(-1, -1)
        }
    }

    /** Calculate load level */
    private fun calculateCpuLoad(current: Long, min: Long, max: Long): CPULoad {
        if (current <= 0 || max <= 0 || min < 0 || max == min) return CPULoad.Low
        val ratio = (current - min).toDouble() / (max - min).toDouble()
        return when {
            ratio < 0.33 -> CPULoad.Low
            ratio < 0.66 -> CPULoad.Medium
            else -> CPULoad.High
        }
    }

    /** Generate flow emitting CpuInfo periodically */
    fun getCpuCoresInformation(): Flow<CpuInfo> {
        val numCores = getNumberOfCores()
        val minMaxFreqs = (0 until numCores).map { getMinMaxFreq(it) }

        val cpuName = getCpuName()
        val abi = getAbi()
        val neon = hasArmNeon()
        val l1dCaches = getL1dCaches().cacheHumanReadable()
        val l1iCaches = getL1iCaches().cacheHumanReadable()
        val l2Caches = getL2Caches().cacheHumanReadable()
        val l3Caches = getL3Caches().cacheHumanReadable()
        val l4Caches = getL4Caches().cacheHumanReadable()

        return flow {
            while (true) {
                val coresData = (0 until numCores).map { getCurrentFreq(it) }
                    .zip(minMaxFreqs)
                    .map { (current, freqPair) ->
                        val (min, max) = freqPair
                        CpuInfo.Frequency(
                            min = min,
                            max = max,
                            current = current,
                            cpuLoad = calculateCpuLoad(current, min, max)
                        )
                    }

                emit(
                    CpuInfo(
                        processorName = cpuName,
                        abi = abi,
                        coreNumber = numCores,
                        hasArmNeon = neon,
                        frequencies = coresData,
                        l1dCaches = l1dCaches,
                        l1iCaches = l1iCaches,
                        l2Caches = l2Caches,
                        l3Caches = l3Caches,
                        l4Caches = l4Caches
                    )
                )

                delay(settings.coreFrequencyRefreshRate)
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        private const val CPU_INFO_DIRECTORY = "/sys/devices/system/cpu/"
    }
}
