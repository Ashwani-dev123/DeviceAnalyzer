package com.example.githhubdemo.deviceinfo.data.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import com.example.githhubdemo.deviceinfo.models.Information;
import org.koin.core.component.KoinComponent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/DeviceDataProvider;", "Lorg/koin/core/component/KoinComponent;", "appContext", "Landroid/content/Context;", "contentResolver", "Landroid/content/ContentResolver;", "wifiManager", "Landroid/net/wifi/WifiManager;", "(Landroid/content/Context;Landroid/content/ContentResolver;Landroid/net/wifi/WifiManager;)V", "getDeviceInformation", "", "Lcom/example/githhubdemo/deviceinfo/models/Information;", "getMainNetworkOperator", "Lkotlin/Result;", "", "getMainNetworkOperator-d1pmJ48", "()Ljava/lang/Object;", "getNetworkType", "app_debug"})
public final class DeviceDataProvider implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.ContentResolver contentResolver = null;
    @org.jetbrains.annotations.NotNull
    private final android.net.wifi.WifiManager wifiManager = null;
    
    public DeviceDataProvider(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    android.content.ContentResolver contentResolver, @org.jetbrains.annotations.NotNull
    android.net.wifi.WifiManager wifiManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> getDeviceInformation() {
        return null;
    }
    
    private final java.lang.String getNetworkType() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}