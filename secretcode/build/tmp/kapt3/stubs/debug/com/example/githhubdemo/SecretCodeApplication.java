package com.example.githhubdemo;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkManager;
import com.chibatching.kotpref.Kotpref;
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider;
import com.example.githhubdemo.deviceinfo.utils.Settings;
import com.example.githhubdemo.deviceinfo.workers.SystemMonitorWorker;
import com.getkeepsafe.relinker.ReLinker;
import com.google.gson.Gson;
import org.koin.core.component.KoinComponent;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/example/githhubdemo/SecretCodeApplication;", "Landroid/app/Application;", "Lorg/koin/core/component/KoinComponent;", "()V", "ADJUST_TOKEN", "", "EVENT_AD_IMPRESSION_ADJUST", "EVENT_PURCHASE_ADJUST", "context", "cpuDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/CpuDataProvider;", "getCpuDataProvider", "()Lcom/example/githhubdemo/deviceinfo/data/provider/CpuDataProvider;", "cpuDataProvider$delegate", "Lkotlin/Lazy;", "settings", "Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "getSettings", "()Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "settings$delegate", "addSystemMonitor", "", "initNativeCpuInfo", "onCreate", "startKoin", "Lorg/koin/core/KoinApplication;", "Companion", "app_debug"})
public final class SecretCodeApplication extends android.app.Application implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String ADJUST_TOKEN = "cc4jvudppczk";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String EVENT_PURCHASE_ADJUST = "gzel1k";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String EVENT_AD_IMPRESSION_ADJUST = "gzel1k";
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy settings$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy cpuDataProvider$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.SecretCodeApplication context;
    private static com.example.githhubdemo.SecretCodeApplication mInstance;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LIB_NAME = "cpuinfo-libs";
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.SecretCodeApplication.Companion Companion = null;
    
    public SecretCodeApplication() {
        super();
    }
    
    private final com.example.githhubdemo.deviceinfo.utils.Settings getSettings() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider getCpuDataProvider() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void addSystemMonitor() {
    }
    
    private final org.koin.core.KoinApplication startKoin() {
        return null;
    }
    
    private final void initNativeCpuInfo() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/githhubdemo/SecretCodeApplication$Companion;", "", "()V", "LIB_NAME", "", "mInstance", "Lcom/example/githhubdemo/SecretCodeApplication;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.githhubdemo.SecretCodeApplication getInstance() {
            return null;
        }
    }
}