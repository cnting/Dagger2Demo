package com.cnting.sample_dagger_android.data

import javax.inject.Inject

class Chef @Inject constructor() : Cooking {

    @Inject
    lateinit var menu: Menu

    override fun cook(): String {
        val menus = menu.menus
        val sb = StringBuilder()
        for ((k, v) in menus) {
            if (v) {
                sb.append(k).append(",")
            }
        }
        return sb.toString()
    }

}