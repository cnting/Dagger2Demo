package com.cnting.sample_dagger_android.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

/**
 * Created by cnting on 2019-03-08
 *
 */
interface ChildWorkFactory {
    fun create(appContext: Context, parameters: WorkerParameters): ListenableWorker
}