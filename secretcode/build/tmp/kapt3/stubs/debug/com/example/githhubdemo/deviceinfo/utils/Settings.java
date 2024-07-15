package com.example.githhubdemo.deviceinfo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.githhubdemo.R;
import com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\nR\u001b\u0010\u0015\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\nR\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "Lcom/example/githhubdemo/deviceinfo/data/local/PreferencesHolder;", "appContext", "Landroid/content/Context;", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/Context;Landroid/content/SharedPreferences;)V", "coreFrequencyRefreshRate", "", "getCoreFrequencyRefreshRate", "()J", "coreFrequencyRefreshRate$delegate", "Lkotlin/properties/ReadWriteProperty;", "monitoringPeriod", "getMonitoringPeriod", "monitoringPeriod$delegate", "getPreferences", "()Landroid/content/SharedPreferences;", "ramRefreshRate", "getRamRefreshRate", "ramRefreshRate$delegate", "ramThresholdPercentage", "getRamThresholdPercentage", "ramThresholdPercentage$delegate", "systemMonitoringState", "", "getSystemMonitoringState", "()Z", "systemMonitoringState$delegate", "Companion", "app_debug"})
public final class Settings implements com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences preferences = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.properties.ReadWriteProperty ramRefreshRate$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.properties.ReadWriteProperty coreFrequencyRefreshRate$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.properties.ReadWriteProperty ramThresholdPercentage$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.properties.ReadWriteProperty monitoringPeriod$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.properties.ReadWriteProperty systemMonitoringState$delegate = null;
    public static final long RAM_REFRESH_RATE_DEFAULT = 5000L;
    public static final long CPU_REFRESH_RATE_DEFAULT = 2000L;
    public static final long RAM_WARNING_FREQUENCY_DEFAULT = 40L;
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.deviceinfo.utils.Settings.Companion Companion = null;
    
    public Settings(@org.jetbrains.annotations.NotNull
    android.content.Context appContext, @org.jetbrains.annotations.NotNull
    android.content.SharedPreferences preferences) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final long getRamRefreshRate() {
        return 0L;
    }
    
    public final long getCoreFrequencyRefreshRate() {
        return 0L;
    }
    
    public final long getRamThresholdPercentage() {
        return 0L;
    }
    
    public final long getMonitoringPeriod() {
        return 0L;
    }
    
    public final boolean getSystemMonitoringState() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/utils/Settings$Companion;", "", "()V", "CPU_REFRESH_RATE_DEFAULT", "", "RAM_REFRESH_RATE_DEFAULT", "RAM_WARNING_FREQUENCY_DEFAULT", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}