package com.cnting.sample_dagger_android.mvvm.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.cnting.sample_dagger_android.R
import com.cnting.sample_dagger_android.mvvm.vm.SecondVM
import com.cnting.sample_login.LoginActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : com.cnting.base.BaseActivity<SecondVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("vm", "===> vm:$vm}")

        initView()
    }

    private fun initView() {
        addFoodCommitBtn.setOnClickListener {
            val text = addFoodEdit.text.toString()
            vm.saveAddFood(text)
        }
        loginBtn.setOnClickListener { startActivity(Intent(this@SecondActivity, LoginActivity::class.java)) }

        vm.finishLiveData.observe(this, Observer {
            val intent = Intent()
            intent.putExtra("add", it ?: "")
            setResult(100, intent)
            finish()
        })
    }
}