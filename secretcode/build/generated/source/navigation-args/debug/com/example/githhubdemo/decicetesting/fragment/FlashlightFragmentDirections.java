package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class FlashlightFragmentDirections {
  private FlashlightFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFlashlightFragmentToLoudSpeakerFragment() {
    return new ActionOnlyNavDirections(R.id.action_flashlightFragment_to_loudSpeakerFragment);
  }
}
