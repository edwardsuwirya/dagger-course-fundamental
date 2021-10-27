package com.enigmacamp.myfulldagger.di.app


import com.enigmacamp.myfulldagger.BaseApplication
import com.enigmacamp.myfulldagger.di.annotation.ActivityScope
import com.enigmacamp.myfulldagger.di.presentation.ActivitiesModule
import com.enigmacamp.myfulldagger.presentation.MainActivityViewModel
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ActivityScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
    ], dependencies = [CoreComponent::class]
)
interface AppComponent : AndroidInjector<BaseApplication>