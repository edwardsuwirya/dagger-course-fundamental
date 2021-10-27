package com.enigmacamp.myfulldagger.di.app

import androidx.lifecycle.ViewModel
import com.enigmacamp.myfulldagger.presentation.MainActivityViewModel
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {
    @Binds
    abstract fun bindsMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}