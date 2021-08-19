package com.enigmacamp.myfulldagger.di.app


import android.app.Application
import com.enigmacamp.myfulldagger.BaseApplication
import com.enigmacamp.myfulldagger.di.presentation.ActivitiesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        CustomerModule::class,
        AuthenticationModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}