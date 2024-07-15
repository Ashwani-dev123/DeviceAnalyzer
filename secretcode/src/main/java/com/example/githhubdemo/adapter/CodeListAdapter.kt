package com.example.githhubdemo.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.githhubdemo.R
import com.example.githhubdemo.model.CodeModel


class CodeListAdapter(private val arrayList: ArrayList<CodeModel>, private val context: Context) : BaseAdapter() {

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
        val codeModel = arrayList[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.code_list_adapter, parent, false)
        
        view.setOnClickListener {}

        view.findViewById<TextView>(R.id.code).text = codeModel.code
        view.findViewById<TextView>(R.id.detals).text = codeModel.details
        
        view.findViewById<ImageView>(R.id.dialerimg).setOnClickListener {
            val code: String = codeModel.code
            Uri.parse("tel:+" + code.trim { it <= ' ' })
            val intent = Intent("android.intent.action.DIAL")
            intent.setData(Uri.parse("tel:" + Uri.encode(code)))
            try {
                context.startActivity(intent)
            } catch (e: SecurityException) {
                e.printStackTrace()
            }
        }
        
        view.findViewById<ImageView>(R.id.copy_txt).setOnClickListener {
            val code = codeModel.code
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Code: ", code)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(it.context, "Copied", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<ImageView>(R.id.share_txt).setOnClickListener {
            val code = codeModel.code
            val details = codeModel.details
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Code: $code\nDetail: $details")
            context.startActivity(Intent.createChooser(intent, "Select app..."))
        }

        return view
    }
}