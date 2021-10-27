package com.enigmacamp.myfulldagger

import com.enigmacamp.myfulldagger.di.app.AppComponent
import com.enigmacamp.myfulldagger.di.app.CoreComponent
import com.enigmacamp.myfulldagger.di.app.DaggerAppComponent
import com.enigmacamp.myfulldagger.di.app.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder().application(this).build()
    }
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().coreComponent(provideCoreComponent()).build()
    }

    private fun provideCoreComponent() = coreComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}