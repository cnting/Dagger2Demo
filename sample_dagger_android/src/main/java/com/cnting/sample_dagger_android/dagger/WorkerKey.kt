package com.cnting.sample_dagger_android.dagger

import androidx.work.ListenableWorker
import dagger.MapKey
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

/**
 * Created by cnting on 2019-03-08
 *
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(RetentionPolicy.RUNTIME)
@MapKey
annotation class WorkerKey(val value: KClass<out ListenableWorker>)