package com.enigmacamp.myfulldagger.di.presentation

import com.enigmacamp.myfulldagger.di.app.AppModule
import com.enigmacamp.myfulldagger.di.app.AuthenticationModule
import com.enigmacamp.myfulldagger.di.app.CustomerModule
import com.enigmacamp.myfulldagger.presentation.CustomerActivity
import com.enigmacamp.myfulldagger.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [AppModule::class, AuthenticationModule::class, CustomerModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [CustomerModule::class])
    abstract fun contributeCustomerActivity(): CustomerActivity
}