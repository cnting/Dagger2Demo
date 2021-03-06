package com.cnting.sample_dagger_android.dagger.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import androidx.work.WorkerFactory
import com.cnting.sample_dagger_android.dagger.ProjectViewModelFactory
import com.cnting.sample_dagger_android.dagger.ProjectWorkerFactory
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule.AbstractModule::class])
class AppModule() {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun providePreference(application: Application): SharedPreferences {
        return application.getSharedPreferences("app_preference", Context.MODE_PRIVATE)
    }

    @Module
    abstract class AbstractModule {   //abstract方法和非abstract不能在一起，所以需要再弄个abstract的module
        @Singleton
        @Binds
        abstract fun provideViewModelFactory(factory: ProjectViewModelFactory): ViewModelProvider.Factory

        @Singleton
        @Binds
        abstract fun providerWorkerFactory(factory: ProjectWorkerFactory): WorkerFactory
    }
}