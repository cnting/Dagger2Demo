package com.cnting.sample_dagger_android.dagger

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

/**
 * Created by cnting on 2019-03-08
 *
 */
@Module(includes = [AssistedInject_AssistedInjectModule::class])
@AssistedModule
interface AssistedInjectModule