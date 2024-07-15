package com.example.githhubdemo.decicetesting.fragment;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import com.example.githhubdemo.R;
import com.example.githhubdemo.databinding.FragmentFlashlightBinding;
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity;
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel;
import com.example.githhubdemo.decicetesting.utils.SharedViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/githhubdemo/decicetesting/fragment/FlashlightFragment;", "Lcom/example/githhubdemo/decicetesting/fragment/BaseFragment;", "()V", "_binding", "Lcom/example/githhubdemo/databinding/FragmentFlashlightBinding;", "binding", "getBinding", "()Lcom/example/githhubdemo/databinding/FragmentFlashlightBinding;", "cameraId", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "isFlashlightOn", "", "sharedViewModel", "Lcom/example/githhubdemo/decicetesting/utils/SharedViewModel;", "viewModel", "Lcom/example/githhubdemo/decicetesting/utils/FeatureTestViewModel;", "getCameraId", "navigateToResultFragment", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "turnOffFlashlight", "turnOnFlashlight", "app_debug"})
public final class FlashlightFragment extends com.example.githhubdemo.decicetesting.fragment.BaseFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.databinding.FragmentFlashlightBinding _binding;
    private boolean isFlashlightOn = false;
    private android.hardware.camera2.CameraManager cameraManager;
    private java.lang.String cameraId;
    private com.example.githhubdemo.decicetesting.utils.SharedViewModel sharedViewModel;
    private com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel viewModel;
    
    public FlashlightFragment() {
        super();
    }
    
    private final com.example.githhubdemo.databinding.FragmentFlashlightBinding getBinding() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
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
    
    private final void navigateToResultFragment() {
    }
    
    private final java.lang.String getCameraId() {
        return null;
    }
    
    private final void turnOnFlashlight() {
    }
    
    private final void turnOffFlashlight() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}