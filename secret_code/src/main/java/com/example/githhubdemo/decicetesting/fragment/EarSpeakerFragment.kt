package com.example.githhubdemo.decicetesting.fragment

import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentEarSpeakerBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickViewModel

class EarSpeakerFragment : BaseFragment() {
    private var _binding: FragmentEarSpeakerBinding? = null
    private val binding get() = _binding!!
    private var audioFocusRequest: AudioFocusRequest? = null
    private var mediaPlayer: MediaPlayer? = null
    private var audioManager: AudioManager? = null

    private val viewModel: ButtonClickViewModel by activityViewModels()
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEarSpeakerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       

        audioManager =
            requireActivity().getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager?

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(3, "yes")
            resetAudioToDefault()
            navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(3, "no")
            resetAudioToDefault()
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
        findNavController().navigate(R.id.microphoneFragment, null, navOptions)
    }

    override fun onResume() {
        super.onResume()
        setAudioToEarpiece()

        mediaPlayer =
            MediaPlayer.create(
                requireActivity(),
                R.raw.simple_ringtone
            ) // replace with your audio file

        mediaPlayer!!.start()
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
        resetAudioToDefault()
    }

    /*private fun setAudioToEarpiece() {
        audioManager?.let { manager ->
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_VOICE_COMMUNICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build()
            audioFocusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                .setAudioAttributes(audioAttributes)
                .setAcceptsDelayedFocusGain(true)
                .setOnAudioFocusChangeListener {
                    // Handle audio focus change if needed
                }
                .build()
            manager.requestAudioFocus(audioFocusRequest!!)
            manager.mode = AudioManager.MODE_IN_COMMUNICATION
            manager.isSpeakerphoneOn = false
        }
    }*/

    private fun setAudioToEarpiece() {
        audioManager?.let { manager ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // For Android O and above
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_VOICE_COMMUNICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()

                audioFocusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                    .setAudioAttributes(audioAttributes)
                    .setAcceptsDelayedFocusGain(true)
                    .setOnAudioFocusChangeListener {
                        // Handle audio focus change if needed
                    }
                    .build()
                manager.requestAudioFocus(audioFocusRequest!!)
            } else {
                // For Android versions below O (API 26)
                manager.requestAudioFocus(null, AudioManager.STREAM_VOICE_CALL, AudioManager.AUDIOFOCUS_GAIN)
            }

            // Set audio mode and disable speakerphone
            manager.mode = AudioManager.MODE_IN_COMMUNICATION
            manager.isSpeakerphoneOn = false
        }
    }


    /*private fun resetAudioToDefault() {
        audioManager?.let { manager ->
            audioFocusRequest?.let { request ->
                manager.abandonAudioFocusRequest(request)
            }
            manager.mode = AudioManager.MODE_NORMAL
            manager.isSpeakerphoneOn = true
        }
    }*/

    private fun resetAudioToDefault() {
        audioManager?.let { manager ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // For Android O and above
                audioFocusRequest?.let { request ->
                    manager.abandonAudioFocusRequest(request)
                }
            } else {
                // For Android versions below O (API 26)
                manager.abandonAudioFocus(null)
            }

            // Reset audio mode and enable speakerphone
            manager.mode = AudioManager.MODE_NORMAL
            manager.isSpeakerphoneOn = true
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}