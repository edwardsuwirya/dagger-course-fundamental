package com.enigmacamp.myfulldagger.di.app

import com.enigmacamp.myfulldagger.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldagger.data.repository.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AuthenticationModule {
    @Binds
    abstract fun bindsAuthenticationRepository(authenticationRepositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository
}