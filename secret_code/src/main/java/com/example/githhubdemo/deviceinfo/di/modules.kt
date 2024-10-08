package com.example.githhubdemo.deviceinfo.di

import android.app.ActivityManager
import android.app.NotificationManager
import android.app.admin.DevicePolicyManager
import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Resources
import android.hardware.SensorManager
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.view.WindowManager
import com.example.githhubdemo.deviceinfo.data.provider.BatteryDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.DeviceDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.GpuDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.NetworkInfoProvider
import com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider
import com.example.githhubdemo.deviceinfo.data.provider.StorageProvider
import com.example.githhubdemo.deviceinfo.data.provider.SystemInfoProvider
import com.example.githhubdemo.deviceinfo.utils.Settings
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


const val SYSINFO_PREFERENCES = "sysinfo_preferences"

private val viewModelModule = module {
    viewModelOf(::DataViewModel)
}

private val providerModule = module {
    singleOf(::CpuDataProvider)
    singleOf(::RamDataProvider)
    singleOf(::GpuDataProvider)
    singleOf(::StorageProvider)
    singleOf(::BatteryDataProvider)
    singleOf(::DeviceDataProvider)
    singleOf(::SystemInfoProvider)
    singleOf(::NetworkInfoProvider)
}

private val appModule = module {
    single<Resources> { androidContext().resources }
    single<ActivityManager> { androidContext().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager }
    single<DevicePolicyManager> { androidContext().getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager }
    single<PackageManager> { androidContext().packageManager }
    single<ContentResolver> { androidContext().contentResolver }
    single<WindowManager> { androidContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager }
    single<SensorManager> { androidContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    single<WifiManager> { get<Context>().applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager }
    single<BatteryManager> { androidContext().getSystemService(Context.BATTERY_SERVICE) as BatteryManager }
    single<NotificationManager> { androidContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }
}

private val persistenceModule = module {
    single { Settings(get(), get()) }
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            SYSINFO_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }
}

private val scopeModule = module {
    single<CoroutineScope> { CoroutineScope(SupervisorJob() + Dispatchers.IO) }
}

val allModules = appModule +
        viewModelModule +
        providerModule +
        persistenceModule +
        scopeModule
