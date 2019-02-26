package com.cnting.sample_dagger_android.mvvm.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.cnting.sample_dagger_android.dagger.ProjectViewModelFactory
import dagger.android.support.DaggerFragment
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

open class BaseFragment<T : ViewModel> : DaggerFragment() {

    @Inject
    lateinit var factory: ProjectViewModelFactory

    val vm: T by lazy {
        ViewModelProviders.of(this as Fragment, factory)
            .get((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>)
    }
}