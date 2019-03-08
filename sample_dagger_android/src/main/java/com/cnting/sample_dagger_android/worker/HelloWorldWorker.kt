package com.cnting.sample_dagger_android.worker

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.cnting.sample_dagger_android.data.Chef
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by cnting on 2019-03-08
 *
 */
class HelloWorldWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted parameters: WorkerParameters,
    private val chef: Chef
) : Worker(appContext, parameters) {
    override fun doWork(): Result {
        Log.d("chef", "chef:$chef")
        return Result.success()
    }

//    class Factory @Inject constructor(private val chef: Provider<Chef>) : ChildWorkFactory {
//        override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
//            return HelloWorldWorker(appContext, params, chef.get())
//        }
//
//    }

    @AssistedInject.Factory
    interface Factory : ChildWorkFactory
}