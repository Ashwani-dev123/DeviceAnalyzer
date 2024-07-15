package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class VibrationFragmentDirections {
  private VibrationFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionVibrationFragmentToBluetoothFragment() {
    return new ActionOnlyNavDirections(R.id.action_vibrationFragment_to_bluetoothFragment);
  }
}
