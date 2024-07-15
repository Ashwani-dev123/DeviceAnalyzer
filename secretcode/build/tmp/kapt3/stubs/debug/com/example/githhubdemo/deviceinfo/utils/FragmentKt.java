package com.example.githhubdemo.deviceinfo.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a/\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\f\u001aX\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00022#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\u00112!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\u0011\u001a\n\u0010\u0017\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0018\u001a\u00020\u0006*\u00020\u0002\u001a(\u0010\u0019\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u0011\u001a\u0012\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0001\u00a8\u0006\u001f"}, d2 = {"getPreferenceKey", "", "Landroidx/fragment/app/Fragment;", "resourceId", "", "nav", "", "id", "directions", "Landroidx/navigation/NavDirections;", "options", "Landroidx/navigation/NavOptions;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;Landroidx/navigation/NavDirections;Landroidx/navigation/NavOptions;)V", "registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onFailure", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "Lkotlin/ParameterName;", "name", "result", "onSuccess", "removeSecure", "secure", "setupActionBar", "layout", "itemSelected", "Landroid/view/MenuItem;", "showToast", "message", "app_debug"})
public final class FragmentKt {
    
    /**
     * Sets the [WindowManager.LayoutParams.FLAG_SECURE] flag for the current activity window.
     */
    public static final void secure(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$secure) {
    }
    
    /**
     * Clears the [WindowManager.LayoutParams.FLAG_SECURE] flag for the current activity window.
     */
    public static final void removeSecure(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$removeSecure) {
    }
    
    /**
     * Registers a fragment to receive activity result through a [ActivityResultLauncher].
     *
     * @param onFailure A callback to be invoked if the resultCode is not `Activity.RESULT_OK`.
     *                 The default implementation does nothing.
     * @param onSuccess A callback to be invoked if the resultCode is `Activity.RESULT_OK`.
     *
     * @return An [ActivityResultLauncher] that can be used to start an activity for result.
     */
    @org.jetbrains.annotations.NotNull
    public static final androidx.activity.result.ActivityResultLauncher<android.content.Intent> registerForActivityResult(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$registerForActivityResult, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.activity.result.ActivityResult, kotlin.Unit> onFailure, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.activity.result.ActivityResult, kotlin.Unit> onSuccess) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getPreferenceKey(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$getPreferenceKey, @androidx.annotation.StringRes
    int resourceId) {
        return null;
    }
    
    public static final void setupActionBar(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$setupActionBar, @androidx.annotation.MenuRes
    int layout, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.view.MenuItem, kotlin.Unit> itemSelected) {
    }
    
    public static final void nav(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$nav, @androidx.annotation.IdRes
    @org.jetbrains.annotations.Nullable
    java.lang.Integer id, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavDirections directions, @org.jetbrains.annotations.Nullable
    androidx.navigation.NavOptions options) {
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment $this$showToast, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
}