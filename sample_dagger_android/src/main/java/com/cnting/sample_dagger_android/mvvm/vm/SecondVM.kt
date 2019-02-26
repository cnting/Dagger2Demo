package com.cnting.sample_dagger_android.mvvm.vm

import android.app.Application
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cnting.sample_dagger_android.data.Menu
import com.google.gson.Gson
import javax.inject.Inject

class SecondVM @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    val finishLiveData = MutableLiveData<String>()

    fun saveAddFood(foodText: String) {
        if (foodText.isEmpty()) {
            Toast.makeText(getApplication(), "请输入菜名", Toast.LENGTH_SHORT).show()
        } else {
            finishLiveData.postValue(foodText)
        }
    }
}