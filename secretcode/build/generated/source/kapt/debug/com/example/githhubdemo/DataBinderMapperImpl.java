package com.example.githhubdemo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.githhubdemo.databinding.DashboardFragmentBindingImpl;
import com.example.githhubdemo.databinding.ItemCpuProgressBindingImpl;
import com.example.githhubdemo.databinding.ItemInformationBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_DASHBOARDFRAGMENT = 1;

  private static final int LAYOUT_ITEMCPUPROGRESS = 2;

  private static final int LAYOUT_ITEMINFORMATION = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.githhubdemo.R.layout.dashboard_fragment, LAYOUT_DASHBOARDFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.githhubdemo.R.layout.item_cpu_progress, LAYOUT_ITEMCPUPROGRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.githhubdemo.R.layout.item_information, LAYOUT_ITEMINFORMATION);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_DASHBOARDFRAGMENT: {
          if ("layout/dashboard_fragment_0".equals(tag)) {
            return new DashboardFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dashboard_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCPUPROGRESS: {
          if ("layout/item_cpu_progress_0".equals(tag)) {
            return new ItemCpuProgressBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_cpu_progress is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINFORMATION: {
          if ("layout/item_information_0".equals(tag)) {
            return new ItemInformationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_information is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.airbnb.epoxy.databinding.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(6);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickListener");
      sKeys.put(2, "cpuInfo");
      sKeys.put(3, "data");
      sKeys.put(4, "position");
      sKeys.put(5, "ramLoad");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(3);

    static {
      sKeys.put("layout/dashboard_fragment_0", com.example.githhubdemo.R.layout.dashboard_fragment);
      sKeys.put("layout/item_cpu_progress_0", com.example.githhubdemo.R.layout.item_cpu_progress);
      sKeys.put("layout/item_information_0", com.example.githhubdemo.R.layout.item_information);
    }
  }
}
