package com.cnting.base

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

open class BaseActivity<T : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val vm: T by lazy {
        ViewModelProviders.of(this as FragmentActivity,factory).get((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>)
    }
}