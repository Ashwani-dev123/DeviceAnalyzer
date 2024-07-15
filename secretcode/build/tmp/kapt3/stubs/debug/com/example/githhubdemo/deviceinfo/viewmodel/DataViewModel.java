package com.example.githhubdemo.deviceinfo.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.githhubdemo.deviceinfo.data.model.BatteryInfo;
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo;
import com.example.githhubdemo.deviceinfo.data.model.RamInfo;
import com.example.githhubdemo.deviceinfo.data.provider.BatteryDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.DeviceDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.GpuDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.NetworkInfoProvider;
import com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider;
import com.example.githhubdemo.deviceinfo.data.provider.StorageProvider;
import com.example.githhubdemo.deviceinfo.data.provider.SystemInfoProvider;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u001a\u0010-\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R\u001a\u00100\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00190\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0017R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0011\u00108\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/viewmodel/DataViewModel;", "Landroidx/lifecycle/ViewModel;", "cpuDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/CpuDataProvider;", "ramDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/RamDataProvider;", "storageProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/StorageProvider;", "batteryDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/BatteryDataProvider;", "gpuDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/GpuDataProvider;", "deviceDataProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/DeviceDataProvider;", "systemInfoProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/SystemInfoProvider;", "networkInfoProvider", "Lcom/example/githhubdemo/deviceinfo/data/provider/NetworkInfoProvider;", "(Lcom/example/githhubdemo/deviceinfo/data/provider/CpuDataProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/RamDataProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/StorageProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/BatteryDataProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/GpuDataProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/DeviceDataProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/SystemInfoProvider;Lcom/example/githhubdemo/deviceinfo/data/provider/NetworkInfoProvider;)V", "batteryInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/githhubdemo/deviceinfo/models/BatteryData;", "getBatteryInfo", "()Lkotlinx/coroutines/flow/Flow;", "cpuInfo", "Lcom/example/githhubdemo/deviceinfo/utils/UiResult;", "Lcom/example/githhubdemo/deviceinfo/models/CpuData;", "getCpuInfo", "deviceData", "", "Lcom/example/githhubdemo/deviceinfo/models/Information;", "getDeviceData", "()Ljava/util/List;", "externalStoragePercentage", "", "getExternalStoragePercentage", "()I", "internalStorageFree", "", "getInternalStorageFree", "()Ljava/lang/String;", "setInternalStorageFree", "(Ljava/lang/String;)V", "internalStoragePercentage", "getInternalStoragePercentage", "internalStorageTotal", "getInternalStorageTotal", "setInternalStorageTotal", "internalStorageUsed", "getInternalStorageUsed", "setInternalStorageUsed", "ramInfo", "Lcom/example/githhubdemo/deviceinfo/models/RamData;", "getRamInfo", "systemInfo", "getSystemInfo", "systemStoragePercentage", "getSystemStoragePercentage", "uptimeFlow", "getUptimeFlow", "app_debug"})
public final class DataViewModel extends androidx.lifecycle.ViewModel {
    private final int systemStoragePercentage = 0;
    private final int internalStoragePercentage = 0;
    private final int externalStoragePercentage = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String internalStorageTotal;
    @org.jetbrains.annotations.NotNull
    private java.lang.String internalStorageFree;
    @org.jetbrains.annotations.NotNull
    private java.lang.String internalStorageUsed;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.models.BatteryData> batteryInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.CpuData>> cpuInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.RamData>> ramInfo = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> systemInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.models.Information> uptimeFlow = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> deviceData = null;
    
    public DataViewModel(@org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider cpuDataProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.RamDataProvider ramDataProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.StorageProvider storageProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.BatteryDataProvider batteryDataProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.GpuDataProvider gpuDataProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.DeviceDataProvider deviceDataProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.SystemInfoProvider systemInfoProvider, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.provider.NetworkInfoProvider networkInfoProvider) {
        super();
    }
    
    public final int getSystemStoragePercentage() {
        return 0;
    }
    
    public final int getInternalStoragePercentage() {
        return 0;
    }
    
    public final int getExternalStoragePercentage() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInternalStorageTotal() {
        return null;
    }
    
    public final void setInternalStorageTotal(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInternalStorageFree() {
        return null;
    }
    
    public final void setInternalStorageFree(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInternalStorageUsed() {
        return null;
    }
    
    public final void setInternalStorageUsed(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.models.BatteryData> getBatteryInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.CpuData>> getCpuInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.RamData>> getRamInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> getSystemInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.githhubdemo.deviceinfo.models.Information> getUptimeFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> getDeviceData() {
        return null;
    }
}