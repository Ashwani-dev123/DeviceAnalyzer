package com.example.githhubdemo.deviceinfo.data.provider;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import com.example.githhubdemo.R;
import com.example.githhubdemo.deviceinfo.data.model.BatteryInfo;
import com.example.githhubdemo.deviceinfo.data.model.BatteryType;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0003J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/BatteryDataProvider;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getBatteryCapacity", "", "getBatteryHealth", "batteryStatus", "Landroid/content/Intent;", "getBatteryHealthStatus", "healthInt", "", "getBatteryLevel", "getBatteryStatus", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/githhubdemo/deviceinfo/data/model/BatteryInfo;", "getBatteryTechnology", "getBatteryTemperature", "getBatteryVoltage", "getChargingType", "getIsCharging", "Lcom/example/githhubdemo/deviceinfo/data/model/BatteryType;", "app_debug"})
public final class BatteryDataProvider {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context appContext = null;
    
    public BatteryDataProvider(@org.jetbrains.annotations.NotNull
    android.content.Context appContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.data.model.BatteryInfo> getBatteryStatus() {
        return null;
    }
    
    private final java.lang.String getBatteryLevel(android.content.Intent batteryStatus) {
        return null;
    }
    
    private final java.lang.String getBatteryHealth(android.content.Intent batteryStatus) {
        return null;
    }
    
    private final java.lang.String getBatteryVoltage(android.content.Intent batteryStatus) {
        return null;
    }
    
    private final java.lang.String getBatteryTemperature(android.content.Intent batteryStatus) {
        return null;
    }
    
    private final java.lang.String getBatteryTechnology(android.content.Intent batteryStatus) {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.data.model.BatteryType getIsCharging(android.content.Intent batteryStatus) {
        return null;
    }
    
    private final java.lang.String getChargingType(android.content.Intent batteryStatus) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"PrivateApi"})
    private final java.lang.String getBatteryCapacity() {
        return null;
    }
    
    private final java.lang.String getBatteryHealthStatus(int healthInt) {
        return null;
    }
}