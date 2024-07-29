package com.example.githhubdemo.decicetesting.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentDisplayBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.activity.DisplayPreviewActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickTracker


class DisplayFragment : BaseFragment() {

    private var _binding: FragmentDisplayBinding? = null
    private val binding get() = _binding!!
    private var LAUNCH_DISPLAY_PREVIEW_ACTIVITY = 1
   

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDisplayBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
       

        binding.btnNext.setOnClickListener {
            val i = Intent(requireActivity(), DisplayPreviewActivity::class.java)
            startActivityForResult(i, LAUNCH_DISPLAY_PREVIEW_ACTIVITY)

        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
             ButtonClickTracker.addButtonClick(0, "no")
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            findNavController().navigate(R.id.flashlightFragment,null,navOptions)
        }

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            ButtonClickTracker.addButtonClick(0, "yes")
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            findNavController().navigate(R.id.flashlightFragment,null,navOptions)
        }

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == LAUNCH_DISPLAY_PREVIEW_ACTIVITY) {
            binding.btnNext.isVisible = false
            binding.tvDetails.text = getString(R.string.were_the_screen_one_solid_color)
            binding.btnYes.isVisible = true
            binding.btnNo.isVisible = true
        }
        else {
            binding.tvDetails.text = getString(R.string.display_may_turn_black_white)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}