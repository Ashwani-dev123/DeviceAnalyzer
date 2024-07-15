package com.example.githhubdemo.deviceinfo.main;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.githhubdemo.R;
import com.example.githhubdemo.deviceinfo.fragment.AppListFragment;
import com.example.githhubdemo.deviceinfo.fragment.BatteryFragment;
import com.example.githhubdemo.deviceinfo.fragment.CPU;
import com.example.githhubdemo.deviceinfo.fragment.Dashboard;
import com.example.githhubdemo.deviceinfo.fragment.DeviceFragment;
import com.example.githhubdemo.deviceinfo.fragment.StorageFragment;
import com.example.githhubdemo.deviceinfo.fragment.SystemFrag;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/main/SectionsPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "context", "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentActivity;", "(Landroid/content/Context;Landroidx/fragment/app/FragmentActivity;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "getPageTitle", "", "TabType", "app_debug"})
public final class SectionsPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    public SectionsPagerAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity fm) {
        super(null);
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.fragment.app.Fragment createFragment(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence getPageTitle(int position) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/main/SectionsPagerAdapter$TabType;", "", "titleResId", "", "fragment", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "(Ljava/lang/String;IILkotlin/jvm/functions/Function0;)V", "getFragment", "()Lkotlin/jvm/functions/Function0;", "getTitleResId", "()I", "DASHBOARD", "DEVICE", "SYSTEM", "STORAGE", "CPU", "BATTERY", "APPS", "Companion", "app_debug"})
    public static enum TabType {
        /*public static final*/ DASHBOARD /* = new DASHBOARD(0, null) */,
        /*public static final*/ DEVICE /* = new DEVICE(0, null) */,
        /*public static final*/ SYSTEM /* = new SYSTEM(0, null) */,
        /*public static final*/ STORAGE /* = new STORAGE(0, null) */,
        /*public static final*/ CPU /* = new CPU(0, null) */,
        /*public static final*/ BATTERY /* = new BATTERY(0, null) */,
        /*public static final*/ APPS /* = new APPS(0, null) */;
        private final int titleResId = 0;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function0<androidx.fragment.app.Fragment> fragment = null;
        @org.jetbrains.annotations.NotNull
        public static final com.example.githhubdemo.deviceinfo.main.SectionsPagerAdapter.TabType.Companion Companion = null;
        
        TabType(int titleResId, kotlin.jvm.functions.Function0<? extends androidx.fragment.app.Fragment> fragment) {
        }
        
        public final int getTitleResId() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function0<androidx.fragment.app.Fragment> getFragment() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/main/SectionsPagerAdapter$TabType$Companion;", "", "()V", "fromPosition", "Lcom/example/githhubdemo/deviceinfo/main/SectionsPagerAdapter$TabType;", "position", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.example.githhubdemo.deviceinfo.main.SectionsPagerAdapter.TabType fromPosition(int position) {
                return null;
            }
        }
    }
}