package com.example.githhubdemo.deviceinfo.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.githhubdemo.R
import com.example.githhubdemo.cpuProgress
import com.example.githhubdemo.databinding.DashboardFragmentBinding
import com.github.lzyzsd.circleprogress.ArcProgress
import com.example.githhubdemo.deviceinfo.main.GridSpacingItemDecoration
import com.example.githhubdemo.deviceinfo.models.CpuData
import com.example.githhubdemo.deviceinfo.models.RamData
import com.example.githhubdemo.deviceinfo.utils.UiResult
import com.example.githhubdemo.deviceinfo.utils.animatedMovement
import com.example.githhubdemo.deviceinfo.utils.launchAndCollectWithViewLifecycle
import com.example.githhubdemo.deviceinfo.utils.nav
import com.example.githhubdemo.deviceinfo.utils.parsePercentage
import com.example.githhubdemo.deviceinfo.utils.setupActionBar
import com.example.githhubdemo.deviceinfo.utils.showToast
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class Dashboard : Fragment(), KoinComponent {

    private val dataViewModel: DataViewModel by viewModel()
    private var _binding: DashboardFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DashboardFragmentBinding.inflate(inflater, container, false)
        _binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentBinding = _binding ?: return

        currentBinding.arcProgress.setRamValueAsync(dataViewModel.ramInfo)
        currentBinding.listView.addItemDecoration(GridSpacingItemDecoration(4, 12, true))
        setupUIElements()
        currentBinding.listView.itemAnimator = null

        launchAndCollectWithViewLifecycle(dataViewModel.cpuInfo) {
            handleCpuInfoResult(it)
        }

        setupActionBar(R.menu.settings_menu) {
            when (it.itemId) {
                R.id.settings -> handleSettings()
            }
        }
    }

    private fun setupUIElements() {
        val currentBinding = _binding ?: return
        currentBinding.systemStorage.setProgressAndText(
            dataViewModel.systemStoragePercentage,
            currentBinding.textView4
        )
      /*  internalProgress.setProgressAndText(
            dataViewModel.internalStoragePercentage,
            internalPercentage
        )*/

        currentBinding.storageProgress.setProgressAndText(
            dataViewModel.internalStoragePercentage,
            currentBinding.tvPercentage
        )

        currentBinding.tvFreeSpace.text = "Free: " + dataViewModel.internalStorageFree + " GB,"
        currentBinding.tvTotalSapce.text = "Total: " + dataViewModel.internalStorageTotal + " GB"

        launchAndCollectWithViewLifecycle(dataViewModel.batteryInfo) { type ->
            val latestBinding = _binding ?: return@launchAndCollectWithViewLifecycle
            val firstBatteryInfo = type.data.firstOrNull() ?: return@launchAndCollectWithViewLifecycle
            val isCharging = type.data.getOrNull(6)?.details == "Charging"
            latestBinding.batteryPercentage.text =
                if (isCharging) "Charging ${firstBatteryInfo.details}" else firstBatteryInfo.details
            latestBinding.batteryProgress.progress = firstBatteryInfo.details.parsePercentage()
            latestBinding.batteryProgress.isIndeterminate = isCharging
        }

        currentBinding.topBar.setOnClickListener(::animatedMovement)
    }

    private fun ProgressBar.setProgressAndText(percentage: Int, textView: TextView) {
        progress = percentage
        textView.text = resources.getString(R.string.percentage_format, percentage.toString())
    }

    private fun handleCpuInfoResult(uiResult: UiResult<CpuData>) {
        when (uiResult) {
            is UiResult.Error -> if (isAdded) {
                showToast(uiResult.throwable.message.orEmpty())
            }
            is UiResult.Success -> updateCpuInfoList(uiResult)
        }
    }

    private fun updateCpuInfoList(uiResult: UiResult.Success<CpuData>) {
        val currentBinding = _binding ?: return
        currentBinding.listView.withModels {
            uiResult.data.frequencies.forEachIndexed { index, frequency ->
                cpuProgress {
                    id("cpu_core_$index")
                    position(index + 1)
                    cpuInfo(frequency)
                    //clickListener(::animatedMovement)
                }
            }
        }
    }

    private fun handleSettings() = nav(
        R.id.containerFragment,
        ContainerFragmentDirections.actionDashboardToSettingsFragment()
    )

    private fun ArcProgress.setRamValueAsync(
        flow: Flow<UiResult<RamData>>
    ) = apply {
        launchAndCollectWithViewLifecycle(flow) { handleRamValueResult(it) }
    }

    private fun handleRamValueResult(result: UiResult<RamData>) {
        when (result) {
            is UiResult.Error -> if (isAdded) {
                showToast(result.throwable.message.orEmpty())
            }
            is UiResult.Success -> {
                val currentBinding = _binding ?: return
                currentBinding.arcProgress.animate(result.data.percentageAvailable)
                currentBinding.ramLoad = result.data.ramLoad
                currentBinding.ramTxt.text = resources.getString(
                    R.string.ram_text,
                    result.data.available,
                    result.data.total
                )
            }

            else -> {}
        }
    }

    private fun ArcProgress.animate(percentageAvailable: Int) = apply {
        ObjectAnimator.ofInt(this, "progress", percentageAvailable).setDuration(1000).start()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
