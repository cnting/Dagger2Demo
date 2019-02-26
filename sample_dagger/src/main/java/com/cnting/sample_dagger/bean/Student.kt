package com.cnting.sample_dagger.bean

import javax.inject.Inject

class Student @Inject constructor(val name: String, age: Int)