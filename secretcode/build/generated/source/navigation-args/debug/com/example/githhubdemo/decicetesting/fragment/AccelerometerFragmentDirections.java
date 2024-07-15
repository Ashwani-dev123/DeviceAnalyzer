package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class AccelerometerFragmentDirections {
  private AccelerometerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAccelerometerFragmentToChargingFragment() {
    return new ActionOnlyNavDirections(R.id.action_accelerometerFragment_to_chargingFragment);
  }
}
