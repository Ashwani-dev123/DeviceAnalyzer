package com.example.githhubdemo.decicetesting.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.githhubdemo.R;
import com.example.githhubdemo.databinding.FragmentDeviceTestingResultBinding;
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity;
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel;
import com.example.githhubdemo.decicetesting.utils.SharedViewModel;
import com.example.githhubdemo.decicetesting.utils.StoragePermissionHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010\'\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J-\u00105\u001a\u00020!2\u0006\u0010)\u001a\u00020\u000f2\u000e\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020$072\u0006\u00108\u001a\u000209H\u0016\u00a2\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020!H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/example/githhubdemo/decicetesting/fragment/DeviceTestingResultFragment;", "Lcom/example/githhubdemo/decicetesting/fragment/BaseFragment;", "()V", "_binding", "Lcom/example/githhubdemo/databinding/FragmentDeviceTestingResultBinding;", "binding", "getBinding", "()Lcom/example/githhubdemo/databinding/FragmentDeviceTestingResultBinding;", "bmp", "Landroid/graphics/Bitmap;", "getBmp", "()Landroid/graphics/Bitmap;", "setBmp", "(Landroid/graphics/Bitmap;)V", "pageHeight", "", "getPageHeight", "()I", "setPageHeight", "(I)V", "pagewidth", "getPagewidth", "setPagewidth", "scaledbmp", "getScaledbmp", "setScaledbmp", "sharedViewModel", "Lcom/example/githhubdemo/decicetesting/utils/SharedViewModel;", "storagePermissionHandler", "Lcom/example/githhubdemo/decicetesting/utils/StoragePermissionHandler;", "viewModel", "Lcom/example/githhubdemo/decicetesting/utils/FeatureTestViewModel;", "checkAndRequestPermissions", "", "generatePdf", "getConditionMassage", "", "percentage", "", "getConditionText", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "savePDF", "pdfFile", "Ljava/io/File;", "setResult", "Companion", "app_debug"})
public final class DeviceTestingResultFragment extends com.example.githhubdemo.decicetesting.fragment.BaseFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.databinding.FragmentDeviceTestingResultBinding _binding;
    private com.example.githhubdemo.decicetesting.utils.SharedViewModel sharedViewModel;
    private com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel viewModel;
    private com.example.githhubdemo.decicetesting.utils.StoragePermissionHandler storagePermissionHandler;
    private int pageHeight = 1120;
    private int pagewidth = 792;
    @org.jetbrains.annotations.Nullable
    private android.graphics.Bitmap bmp;
    @org.jetbrains.annotations.Nullable
    private android.graphics.Bitmap scaledbmp;
    private static final int STORAGE_PERMISSION_CODE = 1001;
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.decicetesting.fragment.DeviceTestingResultFragment.Companion Companion = null;
    
    public DeviceTestingResultFragment() {
        super();
    }
    
    private final com.example.githhubdemo.databinding.FragmentDeviceTestingResultBinding getBinding() {
        return null;
    }
    
    public final int getPageHeight() {
        return 0;
    }
    
    public final void setPageHeight(int p0) {
    }
    
    public final int getPagewidth() {
        return 0;
    }
    
    public final void setPagewidth(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap getBmp() {
        return null;
    }
    
    public final void setBmp(@org.jetbrains.annotations.Nullable
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.Bitmap getScaledbmp() {
        return null;
    }
    
    public final void setScaledbmp(@org.jetbrains.annotations.Nullable
    android.graphics.Bitmap p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setResult() {
    }
    
    private final java.lang.String getConditionText(double percentage) {
        return null;
    }
    
    private final java.lang.String getConditionMassage(double percentage) {
        return null;
    }
    
    private final void generatePdf() {
    }
    
    private final void savePDF(java.io.File pdfFile) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void checkAndRequestPermissions() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/githhubdemo/decicetesting/fragment/DeviceTestingResultFragment$Companion;", "", "()V", "STORAGE_PERMISSION_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}