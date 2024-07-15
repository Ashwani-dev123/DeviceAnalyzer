package com.example.githhubdemo.decicetesting.fragment;

import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import com.example.githhubdemo.R;
import com.example.githhubdemo.databinding.FragmentMicrophoneBinding;
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity;
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel;
import com.example.githhubdemo.decicetesting.utils.SharedViewModel;
import org.jtransforms.fft.DoubleFFT_1D;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J-\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u000b2\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0016\u00a2\u0006\u0002\u00100J\u001a\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u000bH\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/example/githhubdemo/decicetesting/fragment/MicrophoneFragment;", "Lcom/example/githhubdemo/decicetesting/fragment/BaseFragment;", "()V", "_binding", "Lcom/example/githhubdemo/databinding/FragmentMicrophoneBinding;", "audioRecord", "Landroid/media/AudioRecord;", "binding", "getBinding", "()Lcom/example/githhubdemo/databinding/FragmentMicrophoneBinding;", "bufferSize", "", "frequencyBuffer", "", "handler", "Landroid/os/Handler;", "movingAverageWindow", "noiseThreshold", "sampleRate", "sharedViewModel", "Lcom/example/githhubdemo/decicetesting/utils/SharedViewModel;", "viewModel", "Lcom/example/githhubdemo/decicetesting/utils/FeatureTestViewModel;", "calculateFrequency", "buffer", "", "readCount", "checkPermission", "", "navigateToResultFragment", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "startRecording", "updateFrequencyBuffer", "frequency", "updateProgressBar", "Companion", "app_debug"})
public final class MicrophoneFragment extends com.example.githhubdemo.decicetesting.fragment.BaseFragment {
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.databinding.FragmentMicrophoneBinding _binding;
    private final int sampleRate = 44100;
    private final int bufferSize = 0;
    private android.media.AudioRecord audioRecord;
    @org.jetbrains.annotations.NotNull
    private final android.os.Handler handler = null;
    private final int noiseThreshold = 50;
    private final int movingAverageWindow = 5;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Integer> frequencyBuffer = null;
    private com.example.githhubdemo.decicetesting.utils.SharedViewModel sharedViewModel;
    private com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel viewModel;
    public static final int PERMISSION_REQUEST_CODE = 200;
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.decicetesting.fragment.MicrophoneFragment.Companion Companion = null;
    
    public MicrophoneFragment() {
        super();
    }
    
    private final com.example.githhubdemo.databinding.FragmentMicrophoneBinding getBinding() {
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
    
    private final void checkPermission() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    private final void startRecording() {
    }
    
    private final int calculateFrequency(short[] buffer, int readCount) {
        return 0;
    }
    
    private final void updateFrequencyBuffer(int frequency) {
    }
    
    private final void updateProgressBar(int frequency) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/githhubdemo/decicetesting/fragment/MicrophoneFragment$Companion;", "", "()V", "PERMISSION_REQUEST_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}