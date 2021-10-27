package com.enigmacamp.myfulldagger.di.app

import android.app.Application
import com.enigmacamp.myfulldagger.data.SharedPref
import com.enigmacamp.myfulldagger.data.api.AuthApi
import com.enigmacamp.myfulldagger.data.db.AppDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, DataModule::class])
interface CoreComponent {
    fun provideSharedPreferences(): SharedPref
    fun provideDatabase(): AppDatabase
    fun provideAuthApi(): AuthApi

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): CoreComponent
    }
}