package com.cnting.sample_dagger_android.mvvm.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.cnting.sample_dagger_android.R
import com.cnting.sample_dagger_android.mvvm.vm.SecondVM
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity : BaseActivity<SecondVM>() {

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
        vm.finishLiveData.observe(this, Observer {
            val intent = Intent()
            intent.putExtra("add", it ?: "")
            setResult(100, intent)
            finish()
        })
    }
}