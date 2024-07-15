package com.example.githhubdemo.deviceinfo.workers;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.example.githhubdemo.R;
import com.example.githhubdemo.deviceinfo.data.model.CPULoad;
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo;
import com.example.githhubdemo.deviceinfo.data.model.RamInfo;
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider;
import com.example.githhubdemo.deviceinfo.utils.Settings;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.component.KoinComponent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J$\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 H\u0002J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0 2\u0006\u0010%\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010%\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0011\u0010)\u001a\u00020*H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/workers/SystemMonitorWorker;", "Landroidx/work/CoroutineWorker;", "Lorg/koin/core/component/KoinComponent;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "cpuDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/CpuDataProvider;", "getCpuDataProvider", "()Lcom/example/githhubdemo/deviceinfo/data/provider/CpuDataProvider;", "cpuDataProvider$delegate", "Lkotlin/Lazy;", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "notificationManager$delegate", "ramDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/RamDataProvider;", "getRamDataProvider", "()Lcom/example/githhubdemo/deviceinfo/data/provider/RamDataProvider;", "ramDataProvider$delegate", "settings", "Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "getSettings", "()Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "settings$delegate", "checkAndTriggerNotification", "", "ramInfo", "", "Lcom/example/githhubdemo/deviceinfo/data/model/RamInfo;", "cpuInfo", "Lcom/example/githhubdemo/deviceinfo/data/model/CpuInfo;", "collectCpuData", "samples", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectRamData", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNotification", "title", "", "message", "Companion", "app_debug"})
public final class SystemMonitorWorker extends androidx.work.CoroutineWorker implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy ramDataProvider$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy cpuDataProvider$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy notificationManager$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy settings$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RAM_TITLE = "RAM Alert";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RAM_MESSAGE = "Your RAM usage is high.";
    private static final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CPU_TITLE = "CPU Alert";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CPU_MESSAGE = "Your CPU load is high.";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_ID = "SystemMonitorChannel";
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.deviceinfo.workers.SystemMonitorWorker.Companion Companion = null;
    
    public SystemMonitorWorker(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.work.WorkerParameters workerParams) {
        super(null, null);
    }
    
    private final com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider getRamDataProvider() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider getCpuDataProvider() {
        return null;
    }
    
    private final android.app.NotificationManager getNotificationManager() {
        return null;
    }
    
    private final com.example.githhubdemo.deviceinfo.utils.Settings getSettings() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    private final java.lang.Object collectRamData(int samples, kotlin.coroutines.Continuation<? super java.util.List<com.example.githhubdemo.deviceinfo.data.model.RamInfo>> $completion) {
        return null;
    }
    
    private final java.lang.Object collectCpuData(int samples, kotlin.coroutines.Continuation<? super java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo>> $completion) {
        return null;
    }
    
    private final void checkAndTriggerNotification(java.util.List<com.example.githhubdemo.deviceinfo.data.model.RamInfo> ramInfo, java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo> cpuInfo) {
    }
    
    private final void showNotification(java.lang.String title, java.lang.String message) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/workers/SystemMonitorWorker$Companion;", "", "()V", "CHANNEL_ID", "", "CPU_MESSAGE", "CPU_TITLE", "NOTIFICATION_ID", "", "RAM_MESSAGE", "RAM_TITLE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}