package com.example.githhubdemo.deviceinfo.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.githhubdemo.R;
import com.example.githhubdemo.databinding.FragmentAppListBinding;
import com.example.githhubdemo.deviceinfo.adapter.AppAdapter;
import com.example.githhubdemo.deviceinfo.data.model.AppInfo;
import com.example.githhubdemo.utils.Share;
import kotlinx.coroutines.Dispatchers;
import java.io.File;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010\'\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/example/githhubdemo/deviceinfo/fragment/AppListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/githhubdemo/databinding/FragmentAppListBinding;", "adapter", "Lcom/example/githhubdemo/deviceinfo/adapter/AppAdapter;", "binding", "getBinding", "()Lcom/example/githhubdemo/databinding/FragmentAppListBinding;", "installedApps", "Ljava/util/ArrayList;", "Lcom/example/githhubdemo/deviceinfo/data/model/AppInfo;", "Lkotlin/collections/ArrayList;", "progressDialog", "Landroid/app/ProgressDialog;", "AppListFragment", "", "getInstalledApps", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideProgressDialog", "loadInstalledApps", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "showPermissionMessage", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "showPermissionMessageWithDelay", "showProgressDialog", "app_debug"})
public final class AppListFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.example.githhubdemo.deviceinfo.data.model.AppInfo> installedApps;
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.databinding.FragmentAppListBinding _binding;
    private com.example.githhubdemo.deviceinfo.adapter.AppAdapter adapter;
    @org.jetbrains.annotations.Nullable
    private android.app.ProgressDialog progressDialog;
    
    public AppListFragment() {
        super();
    }
    
    private final com.example.githhubdemo.databinding.FragmentAppListBinding getBinding() {
        return null;
    }
    
    public final void AppListFragment() {
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
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final void showProgressDialog() {
    }
    
    private final void hideProgressDialog() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    private final void showPermissionMessageWithDelay(android.content.Context context) {
    }
    
    private final androidx.appcompat.app.AlertDialog showPermissionMessage(android.content.Context context) {
        return null;
    }
    
    private final void loadInstalledApps() {
    }
    
    private final java.lang.Object getInstalledApps(kotlin.coroutines.Continuation<? super java.util.ArrayList<com.example.githhubdemo.deviceinfo.data.model.AppInfo>> $completion) {
        return null;
    }
}