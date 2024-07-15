package com.example.githhubdemo.deviceinfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.githhubdemo.R;
import com.example.githhubdemo.deviceinfo.data.model.AppInfo;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/adapter/AppAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/githhubdemo/deviceinfo/adapter/AppAdapter$AppViewHolder;", "appList", "", "Lcom/example/githhubdemo/deviceinfo/data/model/AppInfo;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "newAppList", "AppViewHolder", "app_debug"})
public final class AppAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.githhubdemo.deviceinfo.adapter.AppAdapter.AppViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.githhubdemo.deviceinfo.data.model.AppInfo> appList;
    
    public AppAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.data.model.AppInfo> appList) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.githhubdemo.deviceinfo.adapter.AppAdapter.AppViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.adapter.AppAdapter.AppViewHolder holder, int position) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.githhubdemo.deviceinfo.data.model.AppInfo> newAppList) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/adapter/AppAdapter$AppViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/githhubdemo/deviceinfo/adapter/AppAdapter;Landroid/view/View;)V", "appIcon", "Landroid/widget/ImageView;", "appName", "Landroid/widget/TextView;", "appSize", "packageName", "versionSize", "bind", "", "appInfo", "Lcom/example/githhubdemo/deviceinfo/data/model/AppInfo;", "getFormattedSize", "", "size", "", "app_debug"})
    public final class AppViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView appIcon = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView appName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView packageName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView versionSize = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView appSize = null;
        
        public AppViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.githhubdemo.deviceinfo.data.model.AppInfo appInfo) {
        }
        
        private final java.lang.String getFormattedSize(long size) {
            return null;
        }
    }
}