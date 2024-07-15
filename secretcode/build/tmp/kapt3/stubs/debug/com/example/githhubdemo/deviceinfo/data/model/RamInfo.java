package com.example.githhubdemo.deviceinfo.data.model;

import com.example.githhubdemo.deviceinfo.models.RamData;
import java.io.Serializable;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/model/RamInfo;", "Ljava/io/Serializable;", "total", "", "available", "percentageAvailable", "", "threshold", "ramLoad", "Lcom/example/githhubdemo/deviceinfo/data/model/RamLoad;", "(JJIJLcom/example/githhubdemo/deviceinfo/data/model/RamLoad;)V", "getAvailable", "()J", "getPercentageAvailable", "()I", "getRamLoad", "()Lcom/example/githhubdemo/deviceinfo/data/model/RamLoad;", "getThreshold", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
public final class RamInfo implements java.io.Serializable {
    private final long total = 0L;
    private final long available = 0L;
    private final int percentageAvailable = 0;
    private final long threshold = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.example.githhubdemo.deviceinfo.data.model.RamLoad ramLoad = null;
    
    public RamInfo(long total, long available, int percentageAvailable, long threshold, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.RamLoad ramLoad) {
        super();
    }
    
    public final long getTotal() {
        return 0L;
    }
    
    public final long getAvailable() {
        return 0L;
    }
    
    public final int getPercentageAvailable() {
        return 0;
    }
    
    public final long getThreshold() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.RamLoad getRamLoad() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.RamLoad component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.RamInfo copy(long total, long available, int percentageAvailable, long threshold, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.RamLoad ramLoad) {
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