package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class ChargingFragmentDirections {
  private ChargingFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionChargingFragmentToVibrationFragment() {
    return new ActionOnlyNavDirections(R.id.action_chargingFragment_to_vibrationFragment);
  }
}
