package com.cnting.sample_dagger_android.dagger.module

import com.cnting.sample_dagger_android.mvvm.ui.fragment.MainFragment
import com.cnting.sample_dagger_android.mvvm.ui.fragment.MainFragment2
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeMainFragment2(): MainFragment2
}