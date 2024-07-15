package com.example.githhubdemo.decicetesting.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity

open class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val currentProgress = DeviceTestingActivity.progressbar!!.progress
                    if (currentProgress > 1) {
                        DeviceTestingActivity.progressbar!!.progress = currentProgress - 1
                        findNavController().popBackStack()
                    } else {
                        // If progress is already 0, perform default back action
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            })
    }
}