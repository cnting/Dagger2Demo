package com.cnting.sample_dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cnting.sample_dagger.bean.Student
import com.cnting.sample_dagger.dagger.component.DaggerMainActivityComponent
import com.cnting.sample_dagger.dagger.module.MainActivityModule
import com.google.gson.Gson
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var student: Student
    @Inject
    lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder()
            .appComponent((application as MyApplication).appComponent)
            .mainActivityModule(MainActivityModule())
            .build()
            .inject(this)

        Log.d("MainActivity", "===>student:${student.name}")
        Log.d("MainActivity", "===>gson:$gson")
    }
}
