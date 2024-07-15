package com.example.githhubdemo.deviceinfo.data.model;

import com.example.githhubdemo.deviceinfo.models.CpuData;
import java.io.Serializable;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u00010B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003Js\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020\u0006H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013\u00a8\u00061"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/model/CpuInfo;", "Ljava/io/Serializable;", "processorName", "", "abi", "coreNumber", "", "hasArmNeon", "", "frequencies", "", "Lcom/example/githhubdemo/deviceinfo/data/model/CpuInfo$Frequency;", "l1dCaches", "l1iCaches", "l2Caches", "l3Caches", "l4Caches", "(Ljava/lang/String;Ljava/lang/String;IZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAbi", "()Ljava/lang/String;", "getCoreNumber", "()I", "getFrequencies", "()Ljava/util/List;", "getHasArmNeon", "()Z", "getL1dCaches", "getL1iCaches", "getL2Caches", "getL3Caches", "getL4Caches", "getProcessorName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "Frequency", "app_debug"})
public final class CpuInfo implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String processorName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String abi = null;
    private final int coreNumber = 0;
    private final boolean hasArmNeon = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> frequencies = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String l1dCaches = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String l1iCaches = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String l2Caches = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String l3Caches = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String l4Caches = null;
    
    public CpuInfo(@org.jetbrains.annotations.NotNull
    java.lang.String processorName, @org.jetbrains.annotations.NotNull
    java.lang.String abi, int coreNumber, boolean hasArmNeon, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> frequencies, @org.jetbrains.annotations.NotNull
    java.lang.String l1dCaches, @org.jetbrains.annotations.NotNull
    java.lang.String l1iCaches, @org.jetbrains.annotations.NotNull
    java.lang.String l2Caches, @org.jetbrains.annotations.NotNull
    java.lang.String l3Caches, @org.jetbrains.annotations.NotNull
    java.lang.String l4Caches) {
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
    public final java.lang.String getL1dCaches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getL1iCaches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getL2Caches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getL3Caches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getL4Caches() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
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
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.CpuInfo copy(@org.jetbrains.annotations.NotNull
    java.lang.String processorName, @org.jetbrains.annotations.NotNull
    java.lang.String abi, int coreNumber, boolean hasArmNeon, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency> frequencies, @org.jetbrains.annotations.NotNull
    java.lang.String l1dCaches, @org.jetbrains.annotations.NotNull
    java.lang.String l1iCaches, @org.jetbrains.annotations.NotNull
    java.lang.String l2Caches, @org.jetbrains.annotations.NotNull
    java.lang.String l3Caches, @org.jetbrains.annotations.NotNull
    java.lang.String l4Caches) {
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/model/CpuInfo$Frequency;", "Ljava/io/Serializable;", "min", "", "max", "current", "cpuLoad", "Lcom/example/githhubdemo/deviceinfo/data/model/CPULoad;", "(JJJLcom/example/githhubdemo/deviceinfo/data/model/CPULoad;)V", "getCpuLoad", "()Lcom/example/githhubdemo/deviceinfo/data/model/CPULoad;", "getCurrent", "()J", "getMax", "getMin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Frequency implements java.io.Serializable {
        private final long min = 0L;
        private final long max = 0L;
        private final long current = 0L;
        @org.jetbrains.annotations.NotNull
        private final com.example.githhubdemo.deviceinfo.data.model.CPULoad cpuLoad = null;
        
        public Frequency(long min, long max, long current, @org.jetbrains.annotations.NotNull
        com.example.githhubdemo.deviceinfo.data.model.CPULoad cpuLoad) {
            super();
        }
        
        public final long getMin() {
            return 0L;
        }
        
        public final long getMax() {
            return 0L;
        }
        
        public final long getCurrent() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.githhubdemo.deviceinfo.data.model.CPULoad getCpuLoad() {
            return null;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final long component3() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.githhubdemo.deviceinfo.data.model.CPULoad component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency copy(long min, long max, long current, @org.jetbrains.annotations.NotNull
        com.example.githhubdemo.deviceinfo.data.model.CPULoad cpuLoad) {
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
}