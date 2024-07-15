package com.example.githhubdemo;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.example.githhubdemo.deviceinfo.models.Information;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Number;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Generated file. Do not modify!
 */
public class InformationBindingModel_ extends DataBindingEpoxyModel implements GeneratedModel<DataBindingEpoxyModel.DataBindingHolder>, InformationBindingModelBuilder {
  private OnModelBoundListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelBoundListener_epoxyGeneratedModel;

  private OnModelUnboundListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelUnboundListener_epoxyGeneratedModel;

  private OnModelVisibilityStateChangedListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

  private OnModelVisibilityChangedListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;

  private Information data;

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
  public InformationBindingModel_ onBind(
      OnModelBoundListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
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
  public InformationBindingModel_ onUnbind(
      OnModelUnboundListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
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
  public InformationBindingModel_ onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
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
  public InformationBindingModel_ onVisibilityChanged(
      OnModelVisibilityChangedListener<InformationBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelVisibilityChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  public InformationBindingModel_ data(Information data) {
    onMutation();
    this.data = data;
    return this;
  }

  public Information data() {
    return data;
  }

  @Override
  public InformationBindingModel_ id(long id) {
    super.id(id);
    return this;
  }

  @Override
  public InformationBindingModel_ id(@Nullable Number... ids) {
    super.id(ids);
    return this;
  }

  @Override
  public InformationBindingModel_ id(long id1, long id2) {
    super.id(id1, id2);
    return this;
  }

  @Override
  public InformationBindingModel_ id(@Nullable CharSequence key) {
    super.id(key);
    return this;
  }

  @Override
  public InformationBindingModel_ id(@Nullable CharSequence key,
      @Nullable CharSequence... otherKeys) {
    super.id(key, otherKeys);
    return this;
  }

  @Override
  public InformationBindingModel_ id(@Nullable CharSequence key, long id) {
    super.id(key, id);
    return this;
  }

  @Override
  public InformationBindingModel_ layout(@LayoutRes int layoutRes) {
    super.layout(layoutRes);
    return this;
  }

  @Override
  public InformationBindingModel_ spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback) {
    super.spanSizeOverride(spanSizeCallback);
    return this;
  }

  @Override
  public InformationBindingModel_ show() {
    super.show();
    return this;
  }

  @Override
  public InformationBindingModel_ show(boolean show) {
    super.show(show);
    return this;
  }

  @Override
  public InformationBindingModel_ hide() {
    super.hide();
    return this;
  }

  @Override
  @LayoutRes
  protected int getDefaultLayout() {
    return R.layout.item_information;
  }

  @Override
  protected void setDataBindingVariables(ViewDataBinding binding) {
    if (!binding.setVariable(BR.data, data)) {
      throw new IllegalStateException("The attribute data was defined in your data binding model (com.airbnb.epoxy.DataBindingEpoxyModel) but a data variable of that name was not found in the layout.");
    }
  }

  @Override
  protected void setDataBindingVariables(ViewDataBinding binding, EpoxyModel previousModel) {
    if (!(previousModel instanceof InformationBindingModel_)) {
      setDataBindingVariables(binding);
      return;
    }
    InformationBindingModel_ that = (InformationBindingModel_) previousModel;
    if ((data != null ? !data.equals(that.data) : that.data != null)) {
      binding.setVariable(BR.data, data);
    }
  }

  @Override
  public InformationBindingModel_ reset() {
    onModelBoundListener_epoxyGeneratedModel = null;
    onModelUnboundListener_epoxyGeneratedModel = null;
    onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
    onModelVisibilityChangedListener_epoxyGeneratedModel = null;
    this.data = null;
    super.reset();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof InformationBindingModel_)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    InformationBindingModel_ that = (InformationBindingModel_) o;
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
    if ((data != null ? !data.equals(that.data) : that.data != null)) {
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
    _result = 31 * _result + (data != null ? data.hashCode() : 0);
    return _result;
  }

  @Override
  public String toString() {
    return "InformationBindingModel_{" +
        "data=" + data +
        "}" + super.toString();
  }
}
