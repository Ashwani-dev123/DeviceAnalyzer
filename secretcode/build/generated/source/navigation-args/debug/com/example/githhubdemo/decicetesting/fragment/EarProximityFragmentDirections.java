package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class EarProximityFragmentDirections {
  private EarProximityFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionEarProximityFragmentToLightSensorFragment() {
    return new ActionOnlyNavDirections(R.id.action_earProximityFragment_to_lightSensorFragment);
  }
}
