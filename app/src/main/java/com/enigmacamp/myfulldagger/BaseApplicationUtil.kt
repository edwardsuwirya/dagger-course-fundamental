package com.enigmacamp.myfulldagger

import android.app.Activity
import com.enigmacamp.myfulldagger.di.app.AppComponent

fun Activity.baseApplication(): BaseApplication {
    return application as BaseApplication
}

val Activity.appComponent: AppComponent
    get() = baseApplication().appComponent
