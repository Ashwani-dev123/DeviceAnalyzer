package com.example.githhubdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.githhubdemo.R
import com.example.githhubdemo.model.DeviceTestItemModel

class DeviceTestAdapter(
    private val arrayList: ArrayList<DeviceTestItemModel>,
    private val context: Context,
    private val itemClickListener: OnDeviceTestItemClickListener
) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val mobileTrickModel = getItem(position) as DeviceTestItemModel
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_list_layout, parent, false)

        view.findViewById<TextView>(R.id.tvMobileTrickTitle).text = mobileTrickModel.toolbarTitle
        view.findViewById<ImageView>(R.id.ivMobileTrickIcon).setImageResource(mobileTrickModel.icon)

        view.setOnClickListener {
            itemClickListener.onDeviceTestItemClick(position)
        }

        return view
    }
    interface OnDeviceTestItemClickListener {
        fun onDeviceTestItemClick(position: Int)
    }
}