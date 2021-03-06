package com.cnting.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

open class BaseFragment<T : ViewModel> : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val vm: T by lazy {
        ViewModelProviders.of(this as Fragment, factory)
            .get((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>)
    }
}