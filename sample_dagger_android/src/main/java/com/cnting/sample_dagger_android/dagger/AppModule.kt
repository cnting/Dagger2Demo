package com.cnting.sample_dagger_android.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import com.cnting.sample_dagger_android.MyApplication
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule.AbstractModule::class])
class AppModule(/*val application: MyApplication*/) {

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

//    @Singleton
//    @Provides
//    fun provideApplication(): Application {
//        return application
//    }

    @Module
    abstract class AbstractModule {   //abstract方法和非abstract不能在一起，所以需要再弄个abstract的module
        @Singleton
        @Binds
        abstract fun provideViewModelFactory(factory: ProjectViewModelFactory): ViewModelProvider.Factory
    }
}