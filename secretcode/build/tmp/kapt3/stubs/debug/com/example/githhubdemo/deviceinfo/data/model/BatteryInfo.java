package com.example.githhubdemo.deviceinfo.data.model;

import com.example.githhubdemo.deviceinfo.models.BatteryData;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/model/BatteryInfo;", "", "level", "", "health", "voltage", "temperature", "capacity", "technology", "isCharging", "Lcom/example/githhubdemo/deviceinfo/data/model/BatteryType;", "chargingType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/githhubdemo/deviceinfo/data/model/BatteryType;Ljava/lang/String;)V", "getCapacity", "()Ljava/lang/String;", "getChargingType", "getHealth", "()Lcom/example/githhubdemo/deviceinfo/data/model/BatteryType;", "getLevel", "getTechnology", "getTemperature", "getVoltage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class BatteryInfo {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String level = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String health = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String voltage = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String temperature = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String capacity = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String technology = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.githhubdemo.deviceinfo.data.model.BatteryType isCharging = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String chargingType = null;
    
    public BatteryInfo(@org.jetbrains.annotations.NotNull
    java.lang.String level, @org.jetbrains.annotations.NotNull
    java.lang.String health, @org.jetbrains.annotations.NotNull
    java.lang.String voltage, @org.jetbrains.annotations.NotNull
    java.lang.String temperature, @org.jetbrains.annotations.NotNull
    java.lang.String capacity, @org.jetbrains.annotations.NotNull
    java.lang.String technology, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.BatteryType isCharging, @org.jetbrains.annotations.NotNull
    java.lang.String chargingType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHealth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVoltage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTemperature() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCapacity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTechnology() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.BatteryType isCharging() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChargingType() {
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
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.BatteryType component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githhubdemo.deviceinfo.data.model.BatteryInfo copy(@org.jetbrains.annotations.NotNull
    java.lang.String level, @org.jetbrains.annotations.NotNull
    java.lang.String health, @org.jetbrains.annotations.NotNull
    java.lang.String voltage, @org.jetbrains.annotations.NotNull
    java.lang.String temperature, @org.jetbrains.annotations.NotNull
    java.lang.String capacity, @org.jetbrains.annotations.NotNull
    java.lang.String technology, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.BatteryType isCharging, @org.jetbrains.annotations.NotNull
    java.lang.String chargingType) {
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