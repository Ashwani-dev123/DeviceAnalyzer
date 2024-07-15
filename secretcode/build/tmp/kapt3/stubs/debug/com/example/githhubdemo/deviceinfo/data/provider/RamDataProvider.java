package com.example.githhubdemo.deviceinfo.data.provider;

import android.app.ActivityManager;
import com.example.githhubdemo.deviceinfo.data.model.RamInfo;
import com.example.githhubdemo.deviceinfo.data.model.RamLoad;
import com.example.githhubdemo.deviceinfo.utils.Settings;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.koin.core.component.KoinComponent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/RamDataProvider;", "Lorg/koin/core/component/KoinComponent;", "activityManager", "Landroid/app/ActivityManager;", "settings", "Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "(Landroid/app/ActivityManager;Lcom/example/githhubdemo/deviceinfo/utils/Settings;)V", "getAvailableBytes", "", "getAvailablePercentage", "", "getRamInformation", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/githhubdemo/deviceinfo/data/model/RamInfo;", "getRamLoad", "Lcom/example/githhubdemo/deviceinfo/data/model/RamLoad;", "getThreshold", "getTotalBytes", "app_debug"})
public final class RamDataProvider implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final android.app.ActivityManager activityManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.githhubdemo.deviceinfo.utils.Settings settings = null;
    
    public RamDataProvider(@org.jetbrains.annotations.NotNull
    android.app.ActivityManager activityManager, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.utils.Settings settings) {
        super();
    }
    
    private final long getTotalBytes() {
        return 0L;
    }
    
    private final long getAvailableBytes() {
        return 0L;
    }
    
    private final int getAvailablePercentage() {
        return 0;
    }
    
    private final long getThreshold() {
        return 0L;
    }
    
    private final com.example.githhubdemo.deviceinfo.data.model.RamLoad getRamLoad() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.data.model.RamInfo> getRamInformation() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}