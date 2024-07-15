package com.example.githhubdemo.deviceinfo.data.provider;

import android.app.ActivityManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.example.githhubdemo.deviceinfo.models.Information;
import kotlinx.coroutines.flow.Flow;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/SystemInfoProvider;", "", "packageManager", "Landroid/content/pm/PackageManager;", "activityManager", "Landroid/app/ActivityManager;", "(Landroid/content/pm/PackageManager;Landroid/app/ActivityManager;)V", "findBinary", "", "binaryName", "", "getAndroidVersion", "Lcom/example/githhubdemo/deviceinfo/models/Information;", "getBaseband", "getBuildNumber", "getGlEsVersion", "getGooglePlayServices", "getJavaVM", "getKernel", "getOpenGL", "glesVersion", "getRootAccess", "getSELinux", "getSecurityPatchLevel", "getSystemInfo", "", "getSystemUptimeFlow", "Lkotlinx/coroutines/flow/Flow;", "getTreble", "app_debug"})
public final class SystemInfoProvider {
    @org.jetbrains.annotations.NotNull
    private final android.content.pm.PackageManager packageManager = null;
    @org.jetbrains.annotations.NotNull
    private final android.app.ActivityManager activityManager = null;
    
    public SystemInfoProvider(@org.jetbrains.annotations.NotNull
    android.content.pm.PackageManager packageManager, @org.jetbrains.annotations.NotNull
    android.app.ActivityManager activityManager) {
        super();
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getAndroidVersion() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getSecurityPatchLevel() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getBuildNumber() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getBaseband() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getJavaVM() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getKernel() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getOpenGL(java.lang.String glesVersion) {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getRootAccess() {
        return null;
    }
    
    private final boolean findBinary(java.lang.String binaryName) {
        return false;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getSELinux() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getGooglePlayServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.models.Information> getSystemUptimeFlow() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.models.Information getTreble() {
        return null;
    }
    
    private final java.lang.String getGlEsVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> getSystemInfo() {
        return null;
    }
}