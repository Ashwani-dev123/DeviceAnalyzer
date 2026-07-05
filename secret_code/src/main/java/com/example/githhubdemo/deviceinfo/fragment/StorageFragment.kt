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
    private val dataViewModel: DataViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = StorageFragmentBinding.inflate(inflater, container, false)
        _binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUIElements()
    }

    private fun setupUIElements() {
        val currentBinding = _binding ?: return
        currentBinding.tvFreeStorage.text = dataViewModel.internalStorageFree + " GB"
        currentBinding.tvTotalStorage.text = dataViewModel.internalStorageTotal + " GB"
        currentBinding.tvUsedStorage.text = dataViewModel.internalStorageUsed + " GB"
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
