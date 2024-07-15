package com.example.githhubdemo.decicetesting.fragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.githhubdemo.R;

public class DisplayFragmentDirections {
  private DisplayFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDisplayFragmentToFlashLightFragment() {
    return new ActionOnlyNavDirections(R.id.action_displayFragment_to_flashLightFragment);
  }
}
