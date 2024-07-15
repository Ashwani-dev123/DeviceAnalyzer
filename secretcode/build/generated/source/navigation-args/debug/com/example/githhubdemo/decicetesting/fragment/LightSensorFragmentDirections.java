package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class LightSensorFragmentDirections {
  private LightSensorFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLightSensorFragmentToAccelerometerFragment() {
    return new ActionOnlyNavDirections(R.id.action_lightSensorFragment_to_accelerometerFragment);
  }
}
