package com.example.githhubdemo.decicetesting.fragment

import android.content.Context
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentVolumeUpBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel
import com.example.githhubdemo.decicetesting.utils.SharedViewModel


class VolumeUpFragment : BaseFragment() {

    private var _binding: FragmentVolumeUpBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var viewModel: FeatureTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVolumeUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[FeatureTestViewModel::class.java]

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(11, "yes")
            viewModel.responses[11] = true
            navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(11, "no")
            viewModel.responses[11] = false
           navigateToResultFragment()
        }


    }

    private fun navigateToResultFragment() {
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
        findNavController().navigate(R.id.volumeDownFragment, null, navOptions)
    }

    fun dispatchKeyEvent(event: KeyEvent): Boolean {
        return if (event.action == KeyEvent.ACTION_DOWN) {
            when (event.keyCode) {
                KeyEvent.KEYCODE_VOLUME_UP -> {
                    adjustVolume(AudioManager.ADJUST_RAISE)
                    performVibration()
                    true
                }
                else -> false
            }
        } else {
            false
        }
    }

    private fun adjustVolume(direction: Int) {
        val audioManager = requireContext().getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager
        audioManager.adjustStreamVolume(
            AudioManager.STREAM_MUSIC,
            direction,
            0 // Pass 0 to prevent the default volume UI from showing
        )
    }

    private fun performVibration() {
        val vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        vibrator?.let {
            if (it.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    it.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    it.vibrate(500)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}