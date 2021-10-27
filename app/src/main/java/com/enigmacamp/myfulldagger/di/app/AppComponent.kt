package com.enigmacamp.myfulldagger.di.app


import android.app.Application
import com.enigmacamp.myfulldagger.BaseApplication
import com.enigmacamp.myfulldagger.di.presentation.ActivitiesModule
import com.enigmacamp.myfulldagger.presentation.MainActivityViewModel
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
    val mainActivityViewModel:MainActivityViewModel

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}