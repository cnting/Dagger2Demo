package com.cnting.sample_dagger_android

import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import com.cnting.sample_dagger_android.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class MyApplication : DaggerApplication() {

    @Inject lateinit var workerFactory: WorkerFactory

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        WorkManager.initialize(this,Configuration.Builder().setWorkerFactory(workerFactory).build())
    }
}