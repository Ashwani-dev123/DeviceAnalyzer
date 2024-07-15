package com.example.githhubdemo.decicetesting.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/example/githhubdemo/decicetesting/utils/StoragePermissionHandler;", "", "()V", "STORAGE_PERMISSION_CODE", "", "getSTORAGE_PERMISSION_CODE", "()I", "checkAndRequestPermissions", "", "activity", "Landroid/app/Activity;", "hasPermissions", "", "context", "Landroid/content/Context;", "permissions", "", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "app_debug"})
public final class StoragePermissionHandler {
    private final int STORAGE_PERMISSION_CODE = 1;
    
    public StoragePermissionHandler() {
        super();
    }
    
    public final int getSTORAGE_PERMISSION_CODE() {
        return 0;
    }
    
    public final void checkAndRequestPermissions(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
    
    private final boolean hasPermissions(android.content.Context context, java.lang.String[] permissions) {
        return false;
    }
}