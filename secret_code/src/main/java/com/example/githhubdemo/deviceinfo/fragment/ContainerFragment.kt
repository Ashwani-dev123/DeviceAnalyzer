package com.example.githhubdemo.deviceinfo.fragment

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentContainerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.githhubdemo.deviceinfo.main.SectionsPagerAdapter
import com.example.githhubdemo.utils.ShareModule


class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private var tabSelectedListener: TabLayout.OnTabSelectedListener? = null
    private var tabLayoutMediator: TabLayoutMediator? = null

    private val tabIcons = intArrayOf(
        R.drawable.ic_dashboard,
        R.drawable.ic_devicee,
        R.drawable.ic_system,
        R.drawable.ic_storage,
        R.drawable.ic_cpu,
        R.drawable.ic_battery,
        R.drawable.ic_screen
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentContainerBinding.inflate(inflater, container, false)
        _binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val currentBinding = _binding ?: return
        val adapter = SectionsPagerAdapter(requireContext(), this)
        with(currentBinding) {
            viewPager.adapter = adapter
            tabLayoutMediator = TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = adapter.getPageTitle(position)
                tab.setIcon(tabIcons[position])
            }.also { mediator ->
                mediator.attach()
            }
        }
        currentBinding.viewPager.offscreenPageLimit = 5

        val listener = object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val selectedTab = tab ?: return
                selectedTab.icon?.setColorFilter(
                    ContextCompat.getColor(requireContext(), R.color.white),
                    PorterDuff.Mode.SRC_IN
                )

                ShareModule.tabPosition = selectedTab.position

                Log.e("CHECKFRAGMENT", "isSelected: " + selectedTab.position)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(
                    ContextCompat.getColor(requireContext(), R.color.textGrey),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Do nothing
            }
        }
        tabSelectedListener = listener
        currentBinding.tabs.addOnTabSelectedListener(listener)

        val firstTab = currentBinding.tabs.getTabAt(0)
        firstTab?.icon?.setColorFilter(
            ContextCompat.getColor(requireContext(), R.color.white),
            PorterDuff.Mode.SRC_IN
        )
    }

    override fun onDestroyView() {
        tabSelectedListener?.let { listener ->
            _binding?.tabs?.removeOnTabSelectedListener(listener)
        }
        tabSelectedListener = null
        tabLayoutMediator?.detach()
        tabLayoutMediator = null
        _binding?.viewPager?.adapter = null
        _binding = null
        super.onDestroyView()
    }
}
