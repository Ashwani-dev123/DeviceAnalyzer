package com.example.githhubdemo.utils

import android.content.Context
import android.widget.Toast
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.gsonpref.gson
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider
import com.example.githhubdemo.deviceinfo.di.allModules
import com.example.githhubdemo.deviceinfo.utils.Settings
import com.example.githhubdemo.deviceinfo.workers.SystemMonitorWorker
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import java.util.concurrent.TimeUnit

object SecretCodeManager : KoinComponent {
    private const val LIB_NAME = "cpuinfo-libs"
    private val settings: Settings by inject()
    private val cpuDataProvider: CpuDataProvider by inject()

    fun initialize(context: Context) {
        Kotpref.init(context)
        Kotpref.gson = Gson()

        startKoin(context)
        initNativeCpuInfo(context)
        addSystemMonitor(context)
    }

    private fun addSystemMonitor(context: Context) {
        val shouldMonitor = settings.systemMonitoringState
        if (shouldMonitor) {
            val workRequest = PeriodicWorkRequestBuilder<SystemMonitorWorker>(
                15,
                TimeUnit.MINUTES
            ).build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }

    private fun startKoin(context: Context) {
        startKoin {
            androidContext(context)
            modules(allModules)
        }
    }


    private fun initNativeCpuInfo(context: Context) {
        try {
//            System.loadLibrary(LIB_NAME)  // Make sure LIB_NAME is correct

        }
        catch (u : UnsatisfiedLinkError) {
            FirebaseCrashlytics.getInstance().log(u.message!!)
            Toast.makeText(context, "Please try again later", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception) {
            Toast.makeText(context, "Please try again later", Toast.LENGTH_SHORT).show()
        }

    }
}