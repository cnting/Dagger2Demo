package com.cnting.sample_dagger_android.dagger.module

import com.cnting.sample_dagger_android.dagger.WorkerKey
import com.cnting.sample_dagger_android.worker.ChildWorkFactory
import com.cnting.sample_dagger_android.worker.HelloWorldWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by cnting on 2019-03-08
 * 参考https://medium.com/@nlg.tuan.kiet/dagger-2-setup-with-workmanager-a-complete-step-by-step-guild-bb9f474bde37
 */
@Module
abstract class WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(HelloWorldWorker::class)
    abstract fun helloWorldWorker(factory: HelloWorldWorker.Factory): ChildWorkFactory
}