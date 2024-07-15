package com.example.githhubdemo.deviceinfo.utils;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.example.githhubdemo.R;
import com.example.githhubdemo.deviceinfo.data.model.CPULoad;
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo;
import com.example.githhubdemo.deviceinfo.data.model.RamLoad;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"coreNumber", "", "Landroid/widget/TextView;", "", "integerText", "number", "", "progress", "Lcom/akexorcist/roundcornerprogressbar/IconRoundCornerProgressBar;", "cpuInfo", "Lcom/example/githhubdemo/deviceinfo/data/model/CpuInfo$Frequency;", "setCpuIcon", "cpuLoad", "Lcom/example/githhubdemo/deviceinfo/data/model/CPULoad;", "setProgressColor", "setRamLoadColor", "Landroidx/cardview/widget/CardView;", "ramLoad", "Lcom/example/githhubdemo/deviceinfo/data/model/RamLoad;", "app_debug"})
public final class ViewBindingKt {
    
    @androidx.databinding.BindingAdapter(value = {"coreNumber"})
    public static final void coreNumber(@org.jetbrains.annotations.NotNull
    android.widget.TextView $this$coreNumber, int coreNumber) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"integerText"})
    public static final void integerText(@org.jetbrains.annotations.NotNull
    android.widget.TextView $this$integerText, long number) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"coreProgress"})
    public static final void progress(@org.jetbrains.annotations.NotNull
    com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar $this$progress, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.CpuInfo.Frequency cpuInfo) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"cpuIcon"})
    public static final void setCpuIcon(@org.jetbrains.annotations.NotNull
    com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar $this$setCpuIcon, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.CPULoad cpuLoad) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"progressColor"})
    public static final void setProgressColor(@org.jetbrains.annotations.NotNull
    com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar $this$setProgressColor, @org.jetbrains.annotations.NotNull
    com.example.githhubdemo.deviceinfo.data.model.CPULoad cpuLoad) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"ramLoadColor"})
    public static final void setRamLoadColor(@org.jetbrains.annotations.NotNull
    androidx.cardview.widget.CardView $this$setRamLoadColor, @org.jetbrains.annotations.Nullable
    com.example.githhubdemo.deviceinfo.data.model.RamLoad ramLoad) {
    }
}