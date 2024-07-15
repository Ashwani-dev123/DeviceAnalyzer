package com.example.githhubdemo;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelClickListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.airbnb.epoxy.WrappedEpoxyModelClickListener;
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Integer;
import java.lang.Number;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Generated file. Do not modify!
 */
public class CpuProgressBindingModel_ extends DataBindingEpoxyModel implements GeneratedModel<DataBindingEpoxyModel.DataBindingHolder>, CpuProgressBindingModelBuilder {
  private OnModelBoundListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelBoundListener_epoxyGeneratedModel;

  private OnModelUnboundListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelUnboundListener_epoxyGeneratedModel;

  private OnModelVisibilityStateChangedListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

  private OnModelVisibilityChangedListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;

  private CpuInfo.Frequency cpuInfo;

  private Integer position;

  private View.OnClickListener clickListener;

  @Override
  public void addTo(EpoxyController controller) {
    super.addTo(controller);
    addWithDebugValidation(controller);
  }

  @Override
  public void handlePreBind(final EpoxyViewHolder holder,
      final DataBindingEpoxyModel.DataBindingHolder object, final int position) {
    validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", position);
  }

  @Override
  public void handlePostBind(final DataBindingEpoxyModel.DataBindingHolder object, int position) {
    if (onModelBoundListener_epoxyGeneratedModel != null) {
      onModelBoundListener_epoxyGeneratedModel.onModelBound(this, object, position);
    }
    validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", position);
  }

  /**
   * Register a listener that will be called when this model is bound to a view.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   * <p>
   * You may clear the listener by setting a null value, or by calling {@link #reset()}
   */
  public CpuProgressBindingModel_ onBind(
      OnModelBoundListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelBoundListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void unbind(DataBindingEpoxyModel.DataBindingHolder object) {
    super.unbind(object);
    if (onModelUnboundListener_epoxyGeneratedModel != null) {
      onModelUnboundListener_epoxyGeneratedModel.onModelUnbound(this, object);
    }
  }

  /**
   * Register a listener that will be called when this model is unbound from a view.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   * <p>
   * You may clear the listener by setting a null value, or by calling {@link #reset()}
   */
  public CpuProgressBindingModel_ onUnbind(
      OnModelUnboundListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelUnboundListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void onVisibilityStateChanged(int visibilityState,
      final DataBindingEpoxyModel.DataBindingHolder object) {
    if (onModelVisibilityStateChangedListener_epoxyGeneratedModel != null) {
      onModelVisibilityStateChangedListener_epoxyGeneratedModel.onVisibilityStateChanged(this, object, visibilityState);
    }
    super.onVisibilityStateChanged(visibilityState, object);
  }

  /**
   * Register a listener that will be called when this model visibility state has changed.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   */
  public CpuProgressBindingModel_ onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth,
      int visibleHeight, int visibleWidth, final DataBindingEpoxyModel.DataBindingHolder object) {
    if (onModelVisibilityChangedListener_epoxyGeneratedModel != null) {
      onModelVisibilityChangedListener_epoxyGeneratedModel.onVisibilityChanged(this, object, percentVisibleHeight, percentVisibleWidth, visibleHeight, visibleWidth);
    }
    super.onVisibilityChanged(percentVisibleHeight, percentVisibleWidth, visibleHeight, visibleWidth, object);
  }

  /**
   * Register a listener that will be called when this model visibility has changed.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   */
  public CpuProgressBindingModel_ onVisibilityChanged(
      OnModelVisibilityChangedListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelVisibilityChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  public CpuProgressBindingModel_ cpuInfo(CpuInfo.Frequency cpuInfo) {
    onMutation();
    this.cpuInfo = cpuInfo;
    return this;
  }

  public CpuInfo.Frequency cpuInfo() {
    return cpuInfo;
  }

  public CpuProgressBindingModel_ position(Integer position) {
    onMutation();
    this.position = position;
    return this;
  }

  public Integer position() {
    return position;
  }

  /**
   * Set a click listener that will provide the parent view, model, and adapter position of the clicked view. This will clear the normal View.OnClickListener if one has been set
   */
  public CpuProgressBindingModel_ clickListener(
      final OnModelClickListener<CpuProgressBindingModel_, DataBindingEpoxyModel.DataBindingHolder> clickListener) {
    onMutation();
    if (clickListener == null) {
      this.clickListener = null;
    }
    else {
      this.clickListener = new WrappedEpoxyModelClickListener<>(clickListener);
    }
    return this;
  }

  public CpuProgressBindingModel_ clickListener(View.OnClickListener clickListener) {
    onMutation();
    this.clickListener = clickListener;
    return this;
  }

  public View.OnClickListener clickListener() {
    return clickListener;
  }

  @Override
  public CpuProgressBindingModel_ id(long id) {
    super.id(id);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ id(@Nullable Number... ids) {
    super.id(ids);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ id(long id1, long id2) {
    super.id(id1, id2);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ id(@Nullable CharSequence key) {
    super.id(key);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ id(@Nullable CharSequence key,
      @Nullable CharSequence... otherKeys) {
    super.id(key, otherKeys);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ id(@Nullable CharSequence key, long id) {
    super.id(key, id);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ layout(@LayoutRes int layoutRes) {
    super.layout(layoutRes);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback) {
    super.spanSizeOverride(spanSizeCallback);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ show() {
    super.show();
    return this;
  }

  @Override
  public CpuProgressBindingModel_ show(boolean show) {
    super.show(show);
    return this;
  }

  @Override
  public CpuProgressBindingModel_ hide() {
    super.hide();
    return this;
  }

  @Override
  @LayoutRes
  protected int getDefaultLayout() {
    return R.layout.item_cpu_progress;
  }

  @Override
  protected void setDataBindingVariables(ViewDataBinding binding) {
    if (!binding.setVariable(BR.cpuInfo, cpuInfo)) {
      throw new IllegalStateException("The attribute cpuInfo was defined in your data binding model (com.airbnb.epoxy.DataBindingEpoxyModel) but a data variable of that name was not found in the layout.");
    }
    if (!binding.setVariable(BR.position, position)) {
      throw new IllegalStateException("The attribute position was defined in your data binding model (com.airbnb.epoxy.DataBindingEpoxyModel) but a data variable of that name was not found in the layout.");
    }
    if (!binding.setVariable(BR.clickListener, clickListener)) {
      throw new IllegalStateException("The attribute clickListener was defined in your data binding model (com.airbnb.epoxy.DataBindingEpoxyModel) but a data variable of that name was not found in the layout.");
    }
  }

  @Override
  protected void setDataBindingVariables(ViewDataBinding binding, EpoxyModel previousModel) {
    if (!(previousModel instanceof CpuProgressBindingModel_)) {
      setDataBindingVariables(binding);
      return;
    }
    CpuProgressBindingModel_ that = (CpuProgressBindingModel_) previousModel;
    if ((cpuInfo != null ? !cpuInfo.equals(that.cpuInfo) : that.cpuInfo != null)) {
      binding.setVariable(BR.cpuInfo, cpuInfo);
    }
    if ((position != null ? !position.equals(that.position) : that.position != null)) {
      binding.setVariable(BR.position, position);
    }
    if (((clickListener == null) != (that.clickListener == null))) {
      binding.setVariable(BR.clickListener, clickListener);
    }
  }

  @Override
  public CpuProgressBindingModel_ reset() {
    onModelBoundListener_epoxyGeneratedModel = null;
    onModelUnboundListener_epoxyGeneratedModel = null;
    onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
    onModelVisibilityChangedListener_epoxyGeneratedModel = null;
    this.cpuInfo = null;
    this.position = null;
    this.clickListener = null;
    super.reset();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CpuProgressBindingModel_)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    CpuProgressBindingModel_ that = (CpuProgressBindingModel_) o;
    if (((onModelBoundListener_epoxyGeneratedModel == null) != (that.onModelBoundListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelUnboundListener_epoxyGeneratedModel == null) != (that.onModelUnboundListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (that.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (that.onModelVisibilityChangedListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if ((cpuInfo != null ? !cpuInfo.equals(that.cpuInfo) : that.cpuInfo != null)) {
      return false;
    }
    if ((position != null ? !position.equals(that.position) : that.position != null)) {
      return false;
    }
    if (((clickListener == null) != (that.clickListener == null))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int _result = super.hashCode();
    _result = 31 * _result + (onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (cpuInfo != null ? cpuInfo.hashCode() : 0);
    _result = 31 * _result + (position != null ? position.hashCode() : 0);
    _result = 31 * _result + (clickListener != null ? 1 : 0);
    return _result;
  }

  @Override
  public String toString() {
    return "CpuProgressBindingModel_{" +
        "cpuInfo=" + cpuInfo +
        ", position=" + position +
        ", clickListener=" + clickListener +
        "}" + super.toString();
  }
}
