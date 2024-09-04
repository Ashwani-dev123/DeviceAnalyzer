package com.example.githhubdemo.deviceinfo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githhubdemo.databinding.CpuFragmentBinding
import com.example.githhubdemo.deviceinfo.utils.Do
import com.example.githhubdemo.deviceinfo.utils.UiResult
import com.example.githhubdemo.deviceinfo.utils.launchAndCollectWithViewLifecycle
import com.example.githhubdemo.deviceinfo.utils.showToast
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import com.example.githhubdemo.information
import org.koin.androidx.viewmodel.ext.android.viewModel

class CPU : Fragment() {

    private var _binding: CpuFragmentBinding? = null
    private val binding get() = _binding!!
    private val dataViewModel: DataViewModel by viewModel()


    fun CPU() {
        // empty constructor
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CpuFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUIElements()
    }

    private fun setupUIElements() {
        binding.listWithItems.layoutManager = LinearLayoutManager(requireContext())
        launchAndCollectWithViewLifecycle(dataViewModel.cpuInfo) { result ->
            binding.progressbar.isVisible = true
            Do exhaustive when (result) {
                is UiResult.Error -> showToast(result.throwable.message.orEmpty())
                is UiResult.Success -> binding.listWithItems.withModels {
                    result.data.layoutInfo.forEach { information ->
                        information {
                            id(information.title)
                            data(information)
                        }
                    }
                    binding.progressbar.isVisible = false
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
