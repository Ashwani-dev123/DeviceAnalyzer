package com.example.githhubdemo.deviceinfo.data.provider;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import org.koin.core.component.KoinComponent;
import java.io.File;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/data/provider/StorageProvider;", "Lorg/koin/core/component/KoinComponent;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateExternalPercentage", "", "calculateFreeInternalStorage", "", "calculateInternalPercentage", "calculateSystemPercentage", "calculateTotalInternalStorage", "calculateTotalUsedInternalStorage", "getExternalStorageUsage", "Lkotlin/Pair;", "", "getFileTypesAndSizes", "", "getInternalStorageUsage", "getSystemStorageUsage", "app_debug"})
public final class StorageProvider implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    public StorageProvider(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final kotlin.Pair<java.lang.Long, java.lang.Long> getSystemStorageUsage() {
        return null;
    }
    
    private final kotlin.Pair<java.lang.Long, java.lang.Long> getInternalStorageUsage() {
        return null;
    }
    
    private final kotlin.Pair<java.lang.Long, java.lang.Long> getExternalStorageUsage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> getFileTypesAndSizes() {
        return null;
    }
    
    public final int calculateSystemPercentage() {
        return 0;
    }
    
    public final int calculateInternalPercentage() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String calculateTotalInternalStorage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String calculateFreeInternalStorage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String calculateTotalUsedInternalStorage() {
        return null;
    }
    
    public final int calculateExternalPercentage() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}