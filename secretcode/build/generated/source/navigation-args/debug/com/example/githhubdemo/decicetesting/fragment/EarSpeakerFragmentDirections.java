package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class EarSpeakerFragmentDirections {
  private EarSpeakerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionEarSpeakerFragmentToMicrophoneFragment() {
    return new ActionOnlyNavDirections(R.id.action_earSpeakerFragment_to_microphoneFragment);
  }
}
