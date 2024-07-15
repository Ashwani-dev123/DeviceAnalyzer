package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class MicrophoneFragmentDirections {
  private MicrophoneFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMicrophoneFragmentToEarProximityFragment() {
    return new ActionOnlyNavDirections(R.id.action_microphoneFragment_to_earProximityFragment);
  }
}
