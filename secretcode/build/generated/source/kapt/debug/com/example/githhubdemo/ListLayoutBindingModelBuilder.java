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
import java.lang.CharSequence;
import java.lang.Number;

@EpoxyBuildScope
public interface ListLayoutBindingModelBuilder {
  ListLayoutBindingModelBuilder onBind(
      OnModelBoundListener<ListLayoutBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ListLayoutBindingModelBuilder onUnbind(
      OnModelUnboundListener<ListLayoutBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ListLayoutBindingModelBuilder onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<ListLayoutBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ListLayoutBindingModelBuilder onVisibilityChanged(
      OnModelVisibilityChangedListener<ListLayoutBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ListLayoutBindingModelBuilder id(long id);

  ListLayoutBindingModelBuilder id(@Nullable Number... ids);

  ListLayoutBindingModelBuilder id(long id1, long id2);

  ListLayoutBindingModelBuilder id(@Nullable CharSequence key);

  ListLayoutBindingModelBuilder id(@Nullable CharSequence key, @Nullable CharSequence... otherKeys);

  ListLayoutBindingModelBuilder id(@Nullable CharSequence key, long id);

  ListLayoutBindingModelBuilder layout(@LayoutRes int layoutRes);

  ListLayoutBindingModelBuilder spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback);
}
