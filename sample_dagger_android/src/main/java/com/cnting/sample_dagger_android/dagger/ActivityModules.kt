package com.cnting.sample_dagger_android.dagger

import com.cnting.sample_dagger_android.mvvm.ui.activity.MainActivity
import com.cnting.sample_dagger_android.mvvm.ui.activity.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * 把需要注入的activity都列出来
 */
@Module
abstract class ActivityModules {

    //通过这个来标记哪个类需要使用依赖注入
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSecondActivity(): SecondActivity
}