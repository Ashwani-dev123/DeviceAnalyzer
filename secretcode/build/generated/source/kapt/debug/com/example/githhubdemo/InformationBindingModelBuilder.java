package com.example.githhubdemo;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyBuildScope;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.example.githhubdemo.deviceinfo.models.Information;
import java.lang.CharSequence;
import java.lang.Number;

@EpoxyBuildScope
public interface InformationBindingModelBuilder {
  InformationBindingModelBuilder onBind(
      OnModelBoundListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  InformationBindingModelBuilder onUnbind(
      OnModelUnboundListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  InformationBindingModelBuilder onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  InformationBindingModelBuilder onVisibilityChanged(
      OnModelVisibilityChangedListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  InformationBindingModelBuilder data(Information data);

  InformationBindingModelBuilder id(long id);

  InformationBindingModelBuilder id(@Nullable Number... ids);

  InformationBindingModelBuilder id(long id1, long id2);

  InformationBindingModelBuilder id(@Nullable CharSequence key);

  InformationBindingModelBuilder id(@Nullable CharSequence key,
      @Nullable CharSequence... otherKeys);

  InformationBindingModelBuilder id(@Nullable CharSequence key, long id);

  InformationBindingModelBuilder layout(@LayoutRes int layoutRes);

  InformationBindingModelBuilder spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback);
}
