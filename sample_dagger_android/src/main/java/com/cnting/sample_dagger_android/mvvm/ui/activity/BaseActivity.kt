package com.cnting.sample_dagger_android.mvvm.ui.activity

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.cnting.sample_dagger_android.dagger.ProjectViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

open class BaseActivity<T : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ProjectViewModelFactory

    val vm: T by lazy {
        ViewModelProviders.of(this as FragmentActivity,factory).get((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>)
    }
}