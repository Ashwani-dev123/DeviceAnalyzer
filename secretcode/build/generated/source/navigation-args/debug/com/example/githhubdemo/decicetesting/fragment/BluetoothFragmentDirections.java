package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class BluetoothFragmentDirections {
  private BluetoothFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionBluetoothFragmentToVolumeUpFragment() {
    return new ActionOnlyNavDirections(R.id.action_bluetoothFragment_to_volumeUpFragment);
  }
}
