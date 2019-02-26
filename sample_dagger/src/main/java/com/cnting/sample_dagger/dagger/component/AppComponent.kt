package com.cnting.sample_dagger.dagger.component

import com.cnting.sample_dagger.dagger.module.AppModule
import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun provideGson(): Gson
}