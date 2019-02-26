package com.cnting.sample_dagger_android.data

import javax.inject.Inject

class Menu @Inject constructor(val menus: MutableMap<String, Boolean>) {
}