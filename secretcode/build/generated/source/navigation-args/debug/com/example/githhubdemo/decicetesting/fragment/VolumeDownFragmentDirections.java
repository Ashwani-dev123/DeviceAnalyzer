package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class VolumeDownFragmentDirections {
  private VolumeDownFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionVolumeDownFragmentToDeviceTestingResultFragment() {
    return new ActionOnlyNavDirections(R.id.action_volumeDownFragment_to_deviceTestingResultFragment);
  }
}
