package com.enigmacamp.myfulldagger

import com.enigmacamp.myfulldagger.di.app.AppComponent
import com.enigmacamp.myfulldagger.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}