package com.cnting.sample_login.dagger

import com.cnting.sample_login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [LoginVMModule::class])
abstract class LoginModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}