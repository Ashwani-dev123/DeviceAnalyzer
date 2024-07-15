package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class VolumeUpFragmentDirections {
  private VolumeUpFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionVolumeUpFragmentToVolumeDownFragment() {
    return new ActionOnlyNavDirections(R.id.action_volumeUpFragment_to_volumeDownFragment);
  }
}
