package com.cnting.sample_dagger.dagger.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}