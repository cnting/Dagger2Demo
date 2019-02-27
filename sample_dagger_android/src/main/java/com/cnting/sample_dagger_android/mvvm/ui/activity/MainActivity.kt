package com.cnting.sample_dagger_android.mvvm.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.size
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cnting.sample_dagger_android.R
import com.cnting.sample_dagger_android.mvvm.ui.adapter.MenuAdapter
import com.cnting.sample_dagger_android.mvvm.ui.fragment.MainFragment
import com.cnting.sample_dagger_android.mvvm.vm.MainVM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : com.cnting.base.BaseActivity<MainVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("vm", "===> vm:$vm,${vm.test()}")
        initAdapter()
        mainAddBtn.setOnClickListener { startActivityForResult(Intent(this, SecondActivity::class.java), 100) }
        floatingBtn.setOnClickListener {
            val fragment = MainFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragmentContainer, fragment)
            transaction.commit()
        }
        vm.refreshLiveData.observe(this, Observer {
            mainList.adapter?.notifyItemInserted(mainList.size)
        })

    }

    private fun initAdapter() {
        val adapter = MenuAdapter(this, vm.getMenus())
        mainList.adapter = adapter
        mainList.layoutManager = LinearLayoutManager(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val addFood = data?.getStringExtra("add") ?: ""
        vm.refreshMenus(addFood)
    }

}
