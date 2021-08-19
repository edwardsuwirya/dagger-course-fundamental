package com.enigmacamp.myfulldagger.di.presentation

import com.enigmacamp.myfulldagger.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}