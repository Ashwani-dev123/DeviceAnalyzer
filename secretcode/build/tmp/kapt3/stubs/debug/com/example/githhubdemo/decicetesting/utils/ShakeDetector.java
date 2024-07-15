package com.example.githhubdemo.decicetesting.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/githhubdemo/decicetesting/utils/ShakeDetector;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "listener", "Lcom/example/githhubdemo/decicetesting/utils/ShakeDetector$OnShakeListener;", "(Landroid/content/Context;Lcom/example/githhubdemo/decicetesting/utils/ShakeDetector$OnShakeListener;)V", "accelerometer", "Landroid/hardware/Sensor;", "lastTime", "", "lastX", "", "lastY", "lastZ", "sensorManager", "Landroid/hardware/SensorManager;", "shakeThreshold", "", "onAccuracyChanged", "", "sensor", "accuracy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "start", "stop", "OnShakeListener", "app_debug"})
public final class ShakeDetector implements android.hardware.SensorEventListener {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.githhubdemo.decicetesting.utils.ShakeDetector.OnShakeListener listener = null;
    @org.jetbrains.annotations.Nullable
    private android.hardware.SensorManager sensorManager;
    @org.jetbrains.annotations.Nullable
    private android.hardware.Sensor accelerometer;
    private float lastX = 0.0F;
    private float lastY = 0.0F;
    private float lastZ = 0.0F;
    private long lastTime = 0L;
    private final int shakeThreshold = 800;
    
    public ShakeDetector(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.decicetesting.utils.ShakeDetector.OnShakeListener listener) {
        super();
    }
    
    public final void start() {
    }
    
    public final void stop() {
    }
    
    @java.lang.Override
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    @java.lang.Override
    public void onSensorChanged(@org.jetbrains.annotations.Nullable
    android.hardware.SensorEvent event) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/githhubdemo/decicetesting/utils/ShakeDetector$OnShakeListener;", "", "onShake", "", "app_debug"})
    public static abstract interface OnShakeListener {
        
        public abstract void onShake();
    }
}