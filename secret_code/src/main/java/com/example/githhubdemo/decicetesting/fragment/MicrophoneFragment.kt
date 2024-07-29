package com.example.githhubdemo.decicetesting.fragment

import android.Manifest.permission.RECORD_AUDIO
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentMicrophoneBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel
import com.example.githhubdemo.decicetesting.utils.SharedViewModel
import org.jtransforms.fft.DoubleFFT_1D
import kotlin.math.pow
import kotlin.math.sqrt

class MicrophoneFragment : BaseFragment() {

    private var _binding: FragmentMicrophoneBinding? = null
    private val binding get() = _binding!!

    private val sampleRate = 44100
    private val bufferSize = AudioRecord.getMinBufferSize(
        sampleRate,
        AudioFormat.CHANNEL_IN_MONO,
        AudioFormat.ENCODING_PCM_16BIT
    )
    private lateinit var audioRecord: AudioRecord
    private val handler = Handler(Looper.getMainLooper())
    private val noiseThreshold = 50
    private val movingAverageWindow = 5
    private val frequencyBuffer = mutableListOf<Int>()
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var viewModel: FeatureTestViewModel

    private var recordingThread: Thread? = null
    private var isRecording = false

    companion object {
        const val PERMISSION_REQUEST_CODE = 200
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMicrophoneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[FeatureTestViewModel::class.java]

        checkPermission()

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(4, "yes")
            viewModel.responses[4] = true
            navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(4, "no")
            viewModel.responses[4] = false
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
        findNavController().navigate(R.id.earProximityFragment, null, navOptions)
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(RECORD_AUDIO),
                PERMISSION_REQUEST_CODE
            )
        } else {
            startRecording()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startRecording()
                } else {
                    Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun startRecording() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(RECORD_AUDIO),
                PERMISSION_REQUEST_CODE
            )
        }else {
            audioRecord = AudioRecord(
                MediaRecorder.AudioSource.MIC,
                sampleRate,
                AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                bufferSize
            )
            audioRecord.startRecording()

            isRecording = true
            recordingThread = Thread {
                val buffer = ShortArray(bufferSize)
                while (isRecording) {
                    val readCount = audioRecord.read(buffer, 0, buffer.size)
                    if (readCount > 0) {
                        val frequency = calculateFrequency(buffer, readCount)
                        if (frequency > noiseThreshold) {
                            updateFrequencyBuffer(frequency)
                            val averageFrequency = frequencyBuffer.average().toInt()
                            updateProgressBar(averageFrequency)
                        } else {
                            updateProgressBar(0)
                        }
                    }
                }
            }
            recordingThread?.start()
        }
    }

    private fun calculateFrequency(buffer: ShortArray, readCount: Int): Int {
        val audioData = buffer.map { it.toDouble() }.toDoubleArray()
        val fft = DoubleFFT_1D(audioData.size.toLong())
        fft.realForward(audioData)

        val magnitudes = audioData.sliceArray(0 until readCount / 2)
        var maxMagnitude = -1.0
        var maxIndex = -1

        for (i in magnitudes.indices) {
            val magnitude = sqrt(magnitudes[i].pow(2.0))
            if (magnitude > maxMagnitude) {
                maxMagnitude = magnitude
                maxIndex = i
            }
        }

        return sampleRate * maxIndex / readCount
    }

    private fun updateFrequencyBuffer(frequency: Int) {
        if (frequencyBuffer.size >= movingAverageWindow) {
            frequencyBuffer.removeAt(0)
        }
        frequencyBuffer.add(frequency)
    }

    private fun updateProgressBar(frequency: Int) {
        handler.post {
            _binding?.let { binding ->
                val progress = (frequency / 1000.0 * binding.progressBar.max).toInt()
                binding.progressBar.progress = progress.coerceIn(0, binding.progressBar.max)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        stopRecording()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        stopRecording()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopRecording()
    }

    private fun stopRecording() {
        if (::audioRecord.isInitialized && audioRecord.state == AudioRecord.STATE_INITIALIZED && isRecording) {
            isRecording = false
            audioRecord.stop()
            audioRecord.release()
            recordingThread?.interrupt()
            recordingThread = null
        }
    }
}

