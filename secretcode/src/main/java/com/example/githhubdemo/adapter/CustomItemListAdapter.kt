package com.example.githhubdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.githhubdemo.R


class CustomItemListAdapter(
    context: Context,
    private val itemList: Array<String>,
    private val itemIcons: Array<Int>
    ) : ArrayAdapter<String>(context, R.layout.item_list_layout, itemList)
    {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView = inflater.inflate(R.layout.item_list_layout, parent, false)

            val titleTextView = rowView.findViewById<TextView>(R.id.tvMobileTrickTitle)
            val iconImageView = rowView.findViewById<ImageView>(R.id.ivMobileTrickIcon)

            titleTextView.text = itemList[position]
            iconImageView.setImageResource(itemIcons[position])

            return rowView
        }

    }