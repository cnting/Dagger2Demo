package com.cnting.sample_dagger_android.mvvm.vm

import android.app.Application
import android.content.SharedPreferences
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cnting.sample_dagger_android.data.Menu
import com.google.gson.Gson
import javax.inject.Inject

class MainVM @Inject constructor(
    application: Application,
    var menu: Menu,
    val preferences: SharedPreferences,
    val gson: Gson
) : AndroidViewModel(application) {

    val refreshLiveData = MutableLiveData<String>()
    val data = mutableListOf<String>()

    fun getMenus(): List<String> {
        data.addAll(menu.menus.keys.toList())
        return data
    }

    fun refreshMenus(addFood: String) {
        data.add(addFood)
        menu.menus.put(addFood, true)
        preferences.edit().putString("menu", gson.toJson(menu.menus)).apply()
        refreshLiveData.postValue(addFood)
    }

    fun test(): String {
        return "test"
    }
}