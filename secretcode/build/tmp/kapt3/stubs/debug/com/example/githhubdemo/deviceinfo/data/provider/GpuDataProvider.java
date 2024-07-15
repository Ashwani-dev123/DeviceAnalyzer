package com.example.githhubdemo.deviceinfo.data.provider;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.os.Build;
import org.koin.core.component.KoinComponent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/GpuDataProvider;", "Lorg/koin/core/component/KoinComponent;", "activityManager", "Landroid/app/ActivityManager;", "packageManager", "Landroid/content/pm/PackageManager;", "(Landroid/app/ActivityManager;Landroid/content/pm/PackageManager;)V", "getGlEsVersion", "", "getVulkanVersion", "app_debug"})
public final class GpuDataProvider implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final android.app.ActivityManager activityManager = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.pm.PackageManager packageManager = null;
    
    public GpuDataProvider(@org.jetbrains.annotations.NotNull
    android.app.ActivityManager activityManager, @org.jetbrains.annotations.NotNull
    android.content.pm.PackageManager packageManager) {
        super();
    }
    
    /**
     * Returns the GLES version of the device as a string.
     *
     * @return A string representation of the GLES version on the device.
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGlEsVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVulkanVersion() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}