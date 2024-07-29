package com.example.githhubdemo.decicetesting.fragment

import android.Manifest.permission.BLUETOOTH_CONNECT
import android.bluetooth.BluetoothAdapter
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentBluetoothBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel
import com.example.githhubdemo.decicetesting.utils.SharedViewModel


class BluetoothFragment : BaseFragment() {

    private var _binding: FragmentBluetoothBinding? = null
    private val binding get() = _binding!!

    private val REQUEST_ENABLE_BT = 1
    private val REQUEST_BLUETOOTH_CONNECT_PERMISSION = 2

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var viewModel: FeatureTestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBluetoothBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[FeatureTestViewModel::class.java]

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (ContextCompat.checkSelfPermission(requireContext(), BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(BLUETOOTH_CONNECT), REQUEST_BLUETOOTH_CONNECT_PERMISSION)
            } else {
                checkBluetooth()
            }
        } else {
            checkBluetooth()
        }




        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(10, "yes")
            viewModel.responses[10] = true
           navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(10, "no")
            viewModel.responses[10] = false
           navigateToResultFragment()
        }
    }

    private fun checkBluetooth() {
        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()

        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            showBluetoothNotSupportedDialog()
        } else {
            // Bluetooth is supported, check if it's enabled
            if (!bluetoothAdapter.isEnabled) {
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
            }
            else {
                binding.tvBluetoothIsON.isVisible = true
            }
        }
    }
    private fun navigateToResultFragment() {

        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
        findNavController().navigate(R.id.volumeUpFragment, null, navOptions)
    }

    private fun showBluetoothNotSupportedDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Bluetooth Not Supported")
            .setMessage("This device does not support Bluetooth.")
            .setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
                // Handle accordingly (e.g., exit app)
                requireActivity().finish()
            }
            .setCancelable(false) // Prevent dialog from being dismissed by tapping outside
            .show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_BLUETOOTH_CONNECT_PERMISSION) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                checkBluetooth()
            } else {
                // Permission denied, handle accordingly
                binding.tvDetails.text = "Bluetooth permission is required to perform this action."
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == AppCompatActivity.RESULT_OK) {

                binding.tvDetails.text = getString(R.string.test_pass)

            } else {
                binding.tvDetails.text = getString(R.string.test_failed)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}