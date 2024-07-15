package com.example.githhubdemo.deviceinfo.fragment;

import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SeekBarPreference;
import androidx.preference.SwitchPreferenceCompat;
import com.example.githhubdemo.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.example.githhubdemo.deviceinfo.utils.Settings;
import org.koin.core.component.KoinComponent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/fragment/SettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lorg/koin/core/component/KoinComponent;", "()V", "preference", "Landroidx/preference/SwitchPreferenceCompat;", "pushNotificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "settings", "Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "getSettings", "()Lcom/example/githhubdemo/deviceinfo/utils/Settings;", "settings$delegate", "Lkotlin/Lazy;", "SettingsFragment", "", "askForPermission", "dialog", "isGranted", "", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "setupPreferences", "app_debug"})
public final class SettingsFragment extends androidx.preference.PreferenceFragmentCompat implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy settings$delegate = null;
    @org.jetbrains.annotations.Nullable
    private androidx.preference.SwitchPreferenceCompat preference;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pushNotificationPermissionLauncher = null;
    
    public SettingsFragment() {
        super();
    }
    
    private final com.example.githhubdemo.deviceinfo.utils.Settings getSettings() {
        return null;
    }
    
    public final void SettingsFragment() {
    }
    
    private final void dialog(boolean isGranted) {
    }
    
    @java.lang.Override
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable
    java.lang.String rootKey) {
    }
    
    private final void askForPermission() {
    }
    
    private final void setupPreferences() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}