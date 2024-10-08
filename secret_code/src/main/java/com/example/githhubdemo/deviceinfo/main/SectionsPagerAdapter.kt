package com.example.githhubdemo.deviceinfo.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.githhubdemo.R
import com.example.githhubdemo.deviceinfo.fragment.BatteryFragment
import com.example.githhubdemo.deviceinfo.fragment.CPU
import com.example.githhubdemo.deviceinfo.fragment.Dashboard
import com.example.githhubdemo.deviceinfo.fragment.DeviceFragment
import com.example.githhubdemo.deviceinfo.fragment.StorageFragment
import com.example.githhubdemo.deviceinfo.fragment.SystemFrag

class SectionsPagerAdapter(
    private val context: Context,
    fm: FragmentActivity
) : FragmentStateAdapter(fm) {
    enum class TabType(val titleResId: Int, val fragment: () -> Fragment) {
        DASHBOARD(R.string.tab_text_1, ::Dashboard),
        DEVICE(R.string.tab_text_2, ::DeviceFragment),
        SYSTEM(R.string.tab_text_3, ::SystemFrag),
        STORAGE(R.string.tab_text_4, ::StorageFragment),
        CPU(R.string.tab_text_5, { CPU() }),
        BATTERY(R.string.tab_text_6, ::BatteryFragment);

        companion object {
            fun fromPosition(position: Int) = values().getOrElse(position) {
                throw IllegalStateException("Invalid position: $position")
            }
        }
    }


    override fun getItemCount(): Int = TabType.values().size

    override fun createFragment(position: Int): Fragment {
        return TabType.fromPosition(position).fragment.invoke()
    }

    fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TabType.fromPosition(position).titleResId)
    }
}
