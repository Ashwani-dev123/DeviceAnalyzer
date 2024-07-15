package com.example.githhubdemo.deviceinfo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.githhubdemo.databinding.StorageFragmentBinding

import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StorageFragment : Fragment() {

    private var _binding: StorageFragmentBinding? = null
    private val binding get() = _binding!!
    private val dataViewModel: DataViewModel by viewModel()

    fun StorageFragment() {
        // empty constructor
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StorageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUIElements()
    }

    private fun setupUIElements() {
        binding.tvFreeStorage.text = dataViewModel.internalStorageFree + " GB"
        binding.tvTotalStorage.text = dataViewModel.internalStorageTotal + " GB"
        binding.tvUsedStorage.text = dataViewModel.internalStorageUsed + " GB"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
