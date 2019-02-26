package com.cnting.sample_dagger.dagger.component

import com.cnting.sample_dagger.MainActivity
import com.cnting.sample_dagger.dagger.module.MainActivityModule
import com.cnting.sample_dagger.dagger.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}