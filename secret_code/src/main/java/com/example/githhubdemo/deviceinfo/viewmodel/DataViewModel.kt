package com.example.githhubdemo.deviceinfo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githhubdemo.deviceinfo.data.model.BatteryInfo
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo
import com.example.githhubdemo.deviceinfo.data.model.RamInfo
import com.example.githhubdemo.deviceinfo.data.model.toDomainModel
import com.example.githhubdemo.deviceinfo.data.provider.BatteryDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.DeviceDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.GpuDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.NetworkInfoProvider
import com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.StorageProvider
import com.example.githhubdemo.deviceinfo.data.provider.SystemInfoProvider
import com.example.githhubdemo.deviceinfo.utils.asResult
import com.example.githhubdemo.deviceinfo.utils.ifChanged
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DataViewModel(
    cpuDataProvider: CpuDataProvider,
    ramDataProvider: RamDataProvider,
    storageProvider: StorageProvider,
    batteryDataProvider: BatteryDataProvider,
    gpuDataProvider: GpuDataProvider,
    deviceDataProvider: DeviceDataProvider,
    systemInfoProvider: SystemInfoProvider,
    networkInfoProvider: NetworkInfoProvider
) : ViewModel() {

    val systemStoragePercentage = storageProvider.calculateSystemPercentage()
    val internalStoragePercentage = storageProvider.calculateInternalPercentage()
    val externalStoragePercentage = storageProvider.calculateExternalPercentage()

    var internalStorageTotal = storageProvider.calculateTotalInternalStorage()
    var internalStorageFree = storageProvider.calculateFreeInternalStorage()
    var internalStorageUsed = storageProvider.calculateTotalUsedInternalStorage()


    val batteryInfo =
        batteryDataProvider.getBatteryStatus().map(BatteryInfo::toDomainModel).ifChanged()

    val cpuInfo =
        cpuDataProvider.getCpuCoresInformation().map(CpuInfo::toDomainModel).ifChanged().asResult()

    val ramInfo =
        ramDataProvider.getRamInformation().map(RamInfo::toDomainModel).ifChanged().asResult()

    val systemInfo =
        systemInfoProvider.getSystemInfo()
    val uptimeFlow = systemInfoProvider.getSystemUptimeFlow()

    val deviceData = deviceDataProvider.getDeviceInformation()

    init {
        viewModelScope.launch(Dispatchers.IO) {

            networkInfoProvider.scanNetwork().forEach {
                Log.e("c", it)
            }
        }
    }
}

private fun <T> Flow<T>.logFlow(name: String = "Flow Logged"): Flow<T> {
    return onEach {
        Log.e(name, "data:$it")
    }
}
