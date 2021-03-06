package com.cnting.sample_dagger_android.mvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cnting.sample_dagger_android.R
import com.cnting.sample_dagger_android.mvvm.vm.MainVM
import kotlinx.android.synthetic.main.fragment_main2.*

class MainFragment2 : com.cnting.base.BaseFragment<MainVM>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("vm", "===>fragment2.vm:$vm")
        fragmentLayout.setOnClickListener {
            if (fragmentManager != null) {
                val transaction = fragmentManager!!.beginTransaction()
                transaction.remove(this)
                transaction.commit()
            }
        }
    }
}