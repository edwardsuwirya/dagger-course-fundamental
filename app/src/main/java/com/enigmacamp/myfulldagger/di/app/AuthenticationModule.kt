package com.enigmacamp.myfulldagger.di.app

import com.enigmacamp.simplesharedpref.data.repository.AuthenticationRepository
import com.enigmacamp.simplesharedpref.data.repository.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AuthenticationModule {
    @Binds
    abstract fun bindsAuthenticationRepository(authenticationRepositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository
}