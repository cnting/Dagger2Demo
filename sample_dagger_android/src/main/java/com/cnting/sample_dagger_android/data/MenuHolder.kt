package com.cnting.sample_dagger_android.data

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cnting.sample_dagger_android.R

class MenuHolder(view: View) : RecyclerView.ViewHolder(view) {

    val menuTv = view.findViewById<TextView>(R.id.menuTv)
    val checkBox = view.findViewById<CheckBox>(R.id.checkbox)

    init {
    }
}