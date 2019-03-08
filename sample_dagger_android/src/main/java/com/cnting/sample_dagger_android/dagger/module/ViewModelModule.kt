package com.cnting.sample_dagger_android.dagger.module

import androidx.lifecycle.ViewModel
import com.cnting.sample_dagger_android.mvvm.vm.MainVM
import com.cnting.sample_dagger_android.mvvm.vm.SecondVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * 负责创建View Model实例，通过@Binds和@IntoMap会生成一个key为类名，value为VM实例的map
 * 具体可以看DaggerAppComponent类的getMapOfClassOfAndProviderOfViewModel()方法
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @com.cnting.base.dagger.ViewModelKey(MainVM::class)
    abstract fun mainViewModel(vm: MainVM): ViewModel

    @Binds
    @IntoMap
    @com.cnting.base.dagger.ViewModelKey(SecondVM::class)
    abstract fun secondViewModel(vm: SecondVM): ViewModel

}