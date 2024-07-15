package com.example.githhubdemo;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyBuildScope;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelClickListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo;
import java.lang.CharSequence;
import java.lang.Integer;
import java.lang.Number;

@EpoxyBuildScope
public interface CpuProgressBindingModelBuilder {
  CpuProgressBindingModelBuilder onBind(
      OnModelBoundListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  CpuProgressBindingModelBuilder onUnbind(
      OnModelUnboundListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  CpuProgressBindingModelBuilder onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  CpuProgressBindingModelBuilder onVisibilityChanged(
      OnModelVisibilityChangedListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  CpuProgressBindingModelBuilder cpuInfo(CpuInfo.Frequency cpuInfo);

  CpuProgressBindingModelBuilder position(Integer position);

  CpuProgressBindingModelBuilder clickListener(
      final OnModelClickListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> clickListener);

  CpuProgressBindingModelBuilder clickListener(View.OnClickListener clickListener);

  CpuProgressBindingModelBuilder id(long id);

  CpuProgressBindingModelBuilder id(@Nullable Number... ids);

  CpuProgressBindingModelBuilder id(long id1, long id2);

  CpuProgressBindingModelBuilder id(@Nullable CharSequence key);

  CpuProgressBindingModelBuilder id(@Nullable CharSequence key,
      @Nullable CharSequence... otherKeys);

  CpuProgressBindingModelBuilder id(@Nullable CharSequence key, long id);

  CpuProgressBindingModelBuilder layout(@LayoutRes int layoutRes);

  CpuProgressBindingModelBuilder spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback);
}
