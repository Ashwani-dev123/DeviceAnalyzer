package com.example.githhubdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.githhubdemo.R
import com.example.githhubdemo.model.MobileTrickModel


class MobileTrickAdapter(private val arrayList: ArrayList<MobileTrickModel>, private val context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val mobileTrickModel = arrayList[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.mobile_tricks_list_adapter, parent, false)
        
        view.setOnClickListener {}

        view.findViewById<TextView>(R.id.tvTitle).text = mobileTrickModel.title
        view.findViewById<TextView>(R.id.tvDisc).text = mobileTrickModel.describtion

        view.findViewById<TextView>(R.id.tvTitle).isVisible = !mobileTrickModel.title.isNullOrEmpty()
        view.findViewById<ImageView>(R.id.view).isVisible = !mobileTrickModel.title.isNullOrEmpty()

        return view
    }
}