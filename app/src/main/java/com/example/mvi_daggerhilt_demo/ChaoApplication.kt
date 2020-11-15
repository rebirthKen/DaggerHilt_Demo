package com.example.mvi_daggerhilt_demo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/***
 * this is the kicking off the hilt code generation
 * it would generate all the components that we need so we can start using hilt
 * it is much easier than we use dagger before
 */
@HiltAndroidApp
class ChaoApplication : Application()