package com.example.githhubdemo.deviceinfo.models;

import com.example.githhubdemo.deviceinfo.data.model.CpuInfo;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/models/CpuData;", "", "processorName", "", "abi", "coreNumber", "", "hasArmNeon", "", "frequencies", "", "Lcom/example/githhubdemo/deviceinfo/data/model/CpuInfo$Frequency;", "layoutInfo", "Lcom/example/githhubdemo/deviceinfo/models/Information;", "(Ljava/lang/String;Ljava/lang/String;IZLjava/util/List;Ljava/util/List;)V", "getAbi", "()Ljava/lang/String;", "getCoreNumber", "()I", "getFrequencies", "()Ljava/util/List;", "getHasArmNeon", "()Z", "getLayoutInfo", "getProcessorName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class CpuData {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String processorName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String abi = null;
    private final int coreNumber = 0;
    private final boolean hasArmNeon = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> frequencies = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> layoutInfo = null;
    
    public CpuData(@org.jetbrains.annotations.NotNull
    java.lang.String processorName, @org.jetbrains.annotations.NotNull
    java.lang.String abi, int coreNumber, boolean hasArmNeon, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> frequencies, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.models.Information> layoutInfo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProcessorName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAbi() {
        return null;
    }
    
    public final int getCoreNumber() {
        return 0;
    }
    
    public final boolean getHasArmNeon() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> getFrequencies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> getLayoutInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.githhubdemo.deviceinfo.models.Information> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.models.CpuData copy(@org.jetbrains.annotations.NotNull
    java.lang.String processorName, @org.jetbrains.annotations.NotNull
    java.lang.String abi, int coreNumber, boolean hasArmNeon, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> frequencies, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.models.Information> layoutInfo) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}