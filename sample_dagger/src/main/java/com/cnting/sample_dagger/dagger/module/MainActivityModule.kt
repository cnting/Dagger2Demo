package com.cnting.sample_dagger.dagger.module

import com.cnting.sample_dagger.bean.Student
import com.cnting.sample_dagger.dagger.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideName(): String {
        return "张三"
    }

    @Provides
    @ActivityScope
    fun provideAge(): Int {
        return 10
    }

    @Provides
    @ActivityScope
    fun provideStudent(name: String, age: Int): Student {
        return Student(name, age)
    }
}