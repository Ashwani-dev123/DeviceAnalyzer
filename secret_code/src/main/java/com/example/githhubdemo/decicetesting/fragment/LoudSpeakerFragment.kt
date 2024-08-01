package com.example.githhubdemo.decicetesting.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentLoudSpeakerBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickViewModel


class LoudSpeakerFragment : BaseFragment() {

    private var _binding: FragmentLoudSpeakerBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer

    private val viewModel: ButtonClickViewModel by activityViewModels()

   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoudSpeakerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.simple_ringtone)

        playSound()


        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(2, "no")
            stopSound()
            navigateToResultFragment()
        }

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(2, "yes")
            stopSound()
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
        findNavController().navigate(R.id.earSpeakerFragment, null, navOptions)
    }

    private fun playSound() {
        mediaPlayer.seekTo(0)
        mediaPlayer.start()
    }

    private fun stopSound() {
        mediaPlayer.apply {
            if (isPlaying) {
                stop()
                prepare()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}