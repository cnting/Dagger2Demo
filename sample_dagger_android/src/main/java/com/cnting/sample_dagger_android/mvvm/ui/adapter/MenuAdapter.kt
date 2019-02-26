package com.cnting.sample_dagger_android.mvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cnting.sample_dagger_android.R
import com.cnting.sample_dagger_android.data.MenuHolder

class MenuAdapter(val context: Context, val data: List<String>) : RecyclerView.Adapter<MenuHolder>() {

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.menuTv.text = data[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_menu_item, parent, false)
        return MenuHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}