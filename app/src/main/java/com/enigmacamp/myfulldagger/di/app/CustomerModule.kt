package com.enigmacamp.myfulldagger.di.app

import com.enigmacamp.myfulldagger.data.repository.CustomerRepository
import com.enigmacamp.myfulldagger.data.repository.CustomerRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CustomerModule {
    @Binds
    abstract fun bindsCustomerRepository(customerRepositoryImpl: CustomerRepositoryImpl): CustomerRepository
}