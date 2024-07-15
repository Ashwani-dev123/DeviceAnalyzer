package com.example.githhubdemo.deviceinfo.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class ContainerFragmentDirections {
  private ContainerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDashboardToSettingsFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboard_to_settingsFragment);
  }
}
