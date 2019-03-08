package com.cnting.sample_dagger_android.dagger.component

import android.app.Application
import com.cnting.sample_dagger_android.MyApplication
import com.cnting.sample_dagger_android.dagger.AssistedInjectModule
import com.cnting.sample_dagger_android.dagger.module.*
import com.cnting.sample_login.dagger.LoginModule
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
        ViewModelModule::class,
        WorkerModule::class,
        AssistedInjectModule::class,
        LoginModule::class]   //其他模块的module直接整合到AppComponent
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}