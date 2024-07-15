package com.example.githhubdemo.deviceinfo.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.githhubdemo.R;
import com.example.githhubdemo.cpuProgress;
import com.example.githhubdemo.databinding.DashboardFragmentBinding;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.example.githhubdemo.deviceinfo.main.GridSpacingItemDecoration;
import com.example.githhubdemo.deviceinfo.models.CpuData;
import com.example.githhubdemo.deviceinfo.models.RamData;
import com.example.githhubdemo.deviceinfo.utils.UiResult;
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel;
import kotlinx.coroutines.flow.Flow;
import org.koin.core.component.KoinComponent;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\u0005H\u0002J\u0016\u0010$\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130%H\u0002J\u0014\u0010&\u001a\u00020\'*\u00020\'2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010*\u001a\u00020\u0010*\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J \u0010/\u001a\u00020\'*\u00020\'2\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001201H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u00062"}, d2 = {"Lcom/example/githhubdemo/deviceinfo/fragment/Dashboard;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/core/component/KoinComponent;", "()V", "_binding", "Lcom/example/githhubdemo/databinding/DashboardFragmentBinding;", "binding", "getBinding", "()Lcom/example/githhubdemo/databinding/DashboardFragmentBinding;", "dataViewModel", "Lcom/example/githhubdemo/deviceinfo/viewmodel/DataViewModel;", "getDataViewModel", "()Lcom/example/githhubdemo/deviceinfo/viewmodel/DataViewModel;", "dataViewModel$delegate", "Lkotlin/Lazy;", "handleCpuInfoResult", "", "uiResult", "Lcom/example/githhubdemo/deviceinfo/utils/UiResult;", "Lcom/example/githhubdemo/deviceinfo/models/CpuData;", "handleRamValueResult", "result", "Lcom/example/githhubdemo/deviceinfo/models/RamData;", "handleSettings", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "setupUIElements", "updateCpuInfoList", "Lcom/example/githhubdemo/deviceinfo/utils/UiResult$Success;", "animate", "Lcom/github/lzyzsd/circleprogress/ArcProgress;", "percentageAvailable", "", "setProgressAndText", "Landroid/widget/ProgressBar;", "percentage", "textView", "Landroid/widget/TextView;", "setRamValueAsync", "flow", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
public final class Dashboard extends androidx.fragment.app.Fragment implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy dataViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.example.githhubdemo.databinding.DashboardFragmentBinding _binding;
    
    public Dashboard() {
        super();
    }
    
    private final com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel getDataViewModel() {
        return null;
    }
    
    private final com.example.githhubdemo.databinding.DashboardFragmentBinding getBinding() {
        return null;
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
    
    private final com.example.githhubdemo.databinding.DashboardFragmentBinding setupUIElements() {
        return null;
    }
    
    private final void setProgressAndText(android.widget.ProgressBar $this$setProgressAndText, int percentage, android.widget.TextView textView) {
    }
    
    private final void handleCpuInfoResult(com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.CpuData> uiResult) {
    }
    
    private final void updateCpuInfoList(com.example.githhubdemo.deviceinfo.utils.UiResult.Success<com.example.githhubdemo.deviceinfo.models.CpuData> uiResult) {
    }
    
    private final void handleSettings() {
    }
    
    private final com.github.lzyzsd.circleprogress.ArcProgress setRamValueAsync(com.github.lzyzsd.circleprogress.ArcProgress $this$setRamValueAsync, kotlinx.coroutines.flow.Flow<? extends com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.RamData>> flow) {
        return null;
    }
    
    private final void handleRamValueResult(com.example.githhubdemo.deviceinfo.utils.UiResult<com.example.githhubdemo.deviceinfo.models.RamData> result) {
    }
    
    private final com.github.lzyzsd.circleprogress.ArcProgress animate(com.github.lzyzsd.circleprogress.ArcProgress $this$animate, int percentageAvailable) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}