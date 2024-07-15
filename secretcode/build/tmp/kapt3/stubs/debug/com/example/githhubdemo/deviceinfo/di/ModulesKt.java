package com.example.githhubdemo.deviceinfo.di;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.view.WindowManager;
import com.example.githhubdemo.deviceinfo.data.provider.BatteryDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.DeviceDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.GpuDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.NetworkInfoProvider;
import com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.StorageProvider;
import com.example.githhubdemo.deviceinfo.data.provider.SystemInfoProvider;
import com.example.githhubdemo.deviceinfo.utils.Settings;
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"SYSINFO_PREFERENCES", "", "allModules", "", "Lorg/koin/core/module/Module;", "getAllModules", "()Ljava/util/List;", "appModule", "persistenceModule", "providerModule", "scopeModule", "viewModelModule", "app_debug"})
public final class ModulesKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SYSINFO_PREFERENCES = "sysinfo_preferences";
    @org.jetbrains.annotations.NotNull
    private static final org.koin.core.module.Module viewModelModule = null;
    @org.jetbrains.annotations.NotNull
    private static final org.koin.core.module.Module providerModule = null;
    @org.jetbrains.annotations.NotNull
    private static final org.koin.core.module.Module appModule = null;
    @org.jetbrains.annotations.NotNull
    private static final org.koin.core.module.Module persistenceModule = null;
    @org.jetbrains.annotations.NotNull
    private static final org.koin.core.module.Module scopeModule = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<org.koin.core.module.Module> allModules = null;
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<org.koin.core.module.Module> getAllModules() {
        return null;
    }
}