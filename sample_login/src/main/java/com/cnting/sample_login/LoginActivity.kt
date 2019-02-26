package com.cnting.sample_login

import android.os.Bundle
import android.util.Log

class LoginActivity : com.cnting.base.BaseActivity<LoginVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("LoginActivity", "===>vm:$vm")
    }
}
