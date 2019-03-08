package com.cnting.sample_dagger_android.dagger

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.cnting.sample_dagger_android.worker.ChildWorkFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by cnting on 2019-03-08
 *
 */
class ProjectWorkerFactory @Inject constructor(private val workerFactorys: Map<Class<out ListenableWorker>, @JvmSuppressWildcards Provider<ChildWorkFactory>>) :
    WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        val foundEntry = workerFactorys.entries.find { Class.forName(workerClassName).isAssignableFrom(it.key) }
        val factoryProvider = foundEntry?.value
            ?: throw IllegalArgumentException("unknown worker class name: $workerClassName")
        return factoryProvider.get().create(appContext, workerParameters)
    }

}