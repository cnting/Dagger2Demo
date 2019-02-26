package com.cnting.sample_login.dagger

import androidx.lifecycle.ViewModel
import com.cnting.base.dagger.ViewModelKey
import com.cnting.sample_login.LoginVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginVMModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginVM::class)
    abstract fun contributeLoginVM(vm: LoginVM): ViewModel
}