package com.example.githhubdemo.decicetesting.fragment;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import com.example.githhubdemo.R;
import com.example.githhubdemo.databinding.FragmentAccelerometerBinding;
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity;
import com.example.githhubdemo.decicetesting.utils.ShakeDetector;
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel;
import com.example.githhubdemo.decicetesting.utils.SharedViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u001a\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/githhubdemo/decicetesting/fragment/AccelerometerFragment;", "Lcom/example/githhubdemo/decicetesting/fragment/BaseFragment;", "Lcom/example/githhubdemo/decicetesting/utils/ShakeDetector$OnShakeListener;", "()V", "_binding", "Lcom/example/githhubdemo/databinding/FragmentAccelerometerBinding;", "binding", "getBinding", "()Lcom/example/githhubdemo/databinding/FragmentAccelerometerBinding;", "shakeDetector", "Lcom/example/githhubdemo/decicetesting/utils/ShakeDetector;", "sharedViewModel", "Lcom/example/githhubdemo/decicetesting/utils/SharedViewModel;", "vibrator", "Landroid/os/Vibrator;", "viewModel", "Lcom/example/githhubdemo/decicetesting/utils/FeatureTestViewModel;", "navigateToResultFragment", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPause", "onResume", "onShake", "onViewCreated", "view", "app_debug"})
public final class AccelerometerFragment extends com.example.githhubdemo.decicetesting.fragment.BaseFragment implements com.example.githhubdemo.decicetesting.utils.ShakeDetector.OnShakeListener {
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.databinding.FragmentAccelerometerBinding _binding;
    private com.example.githhubdemo.decicetesting.utils.ShakeDetector shakeDetector;
    private android.os.Vibrator vibrator;
    private com.example.githhubdemo.decicetesting.utils.SharedViewModel sharedViewModel;
    private com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel viewModel;
    
    public AccelerometerFragment() {
        super();
    }
    
    private final com.example.githhubdemo.databinding.FragmentAccelerometerBinding getBinding() {
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
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onShake() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}