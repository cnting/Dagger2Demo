package com.cnting.sample_dagger_android.dagger.component

import android.app.Application
import com.cnting.sample_dagger_android.MyApplication
import com.cnting.sample_dagger_android.dagger.ActivityModules
import com.cnting.sample_dagger_android.dagger.AppModule
import com.cnting.sample_dagger_android.dagger.CookModule
import com.cnting.sample_dagger_android.dagger.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityModules::class,
        CookModule::class,
        AppModule::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<MyApplication> {


    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}