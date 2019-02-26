package com.cnting.sample_dagger_android.mvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cnting.sample_dagger_android.R
import com.cnting.sample_dagger_android.mvvm.vm.MainVM
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<MainVM>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("vm", "===>fragment.vm:$vm")
        fragmentLayout.setOnClickListener {
            if (fragmentManager != null) {
                val transaction = fragmentManager!!.beginTransaction()
                val fragment = MainFragment2()
                transaction.replace(R.id.fragmentContainer, fragment)
                transaction.commit()
            }
        }
    }
}