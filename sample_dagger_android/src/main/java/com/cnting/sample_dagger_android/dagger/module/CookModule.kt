package com.cnting.sample_dagger_android.dagger.module

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CookModule {

    @Singleton
    @Provides
    fun provideMenus(sharedPreferences: SharedPreferences, gson: Gson): MutableMap<String, Boolean> {
        val menuGson = sharedPreferences.getString("menu", "")
        return if (menuGson.isEmpty()) {
            val map = mutableMapOf<String, Boolean>()
            map["酸菜鱼"] = true
            map["土豆"] = true
            map["牛肉"] = true
            sharedPreferences.edit().putString("menu", gson.toJson(map)).apply()
            map
        } else {
            gson.fromJson(menuGson, object : TypeToken<Map<String, Boolean>>() {}.type)
        }
    }
}