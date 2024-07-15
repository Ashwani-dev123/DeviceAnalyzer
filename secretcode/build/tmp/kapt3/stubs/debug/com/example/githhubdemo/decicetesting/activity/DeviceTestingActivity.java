package com.example.githhubdemo.decicetesting.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.example.githhubdemo.R;
import com.example.githhubdemo.databinding.ActivityDeviceTestingBinding;
import com.example.githhubdemo.decicetesting.fragment.VolumeUpFragment;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/githhubdemo/decicetesting/activity/DeviceTestingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/githhubdemo/databinding/ActivityDeviceTestingBinding;", "navController", "Landroidx/navigation/NavController;", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "Companion", "app_debug"})
public final class DeviceTestingActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.githhubdemo.databinding.ActivityDeviceTestingBinding binding;
    private androidx.navigation.NavController navController;
    @org.jetbrains.annotations.Nullable
    private static android.widget.ProgressBar progressbar;
    private static boolean isPopBackStack = false;
    private static boolean isYesOrNoButton = false;
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity.Companion Companion = null;
    
    public DeviceTestingActivity() {
        super();
    }
    
    @java.lang.Override
    public boolean dispatchKeyEvent(@org.jetbrains.annotations.NotNull
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/githhubdemo/decicetesting/activity/DeviceTestingActivity$Companion;", "", "()V", "isPopBackStack", "", "()Z", "setPopBackStack", "(Z)V", "isYesOrNoButton", "setYesOrNoButton", "progressbar", "Landroid/widget/ProgressBar;", "getProgressbar", "()Landroid/widget/ProgressBar;", "setProgressbar", "(Landroid/widget/ProgressBar;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final android.widget.ProgressBar getProgressbar() {
            return null;
        }
        
        public final void setProgressbar(@org.jetbrains.annotations.Nullable
        android.widget.ProgressBar p0) {
        }
        
        public final boolean isPopBackStack() {
            return false;
        }
        
        public final void setPopBackStack(boolean p0) {
        }
        
        public final boolean isYesOrNoButton() {
            return false;
        }
        
        public final void setYesOrNoButton(boolean p0) {
        }
    }
}