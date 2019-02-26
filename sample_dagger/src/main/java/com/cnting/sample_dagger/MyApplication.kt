package com.cnting.sample_dagger

import android.app.Application
import com.cnting.sample_dagger.dagger.component.AppComponent
import com.cnting.sample_dagger.dagger.component.DaggerAppComponent
import com.cnting.sample_dagger.dagger.module.AppModule

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }
}