package com.enigmacamp.myfulldagger.di.app

import androidx.lifecycle.ViewModel
import com.enigmacamp.myfulldagger.data.repository.CustomerRepository
import com.enigmacamp.myfulldagger.data.repository.CustomerRepositoryImpl
import com.enigmacamp.myfulldagger.presentation.CustomerActivityViewModel
import com.enigmacamp.myfulldagger.presentation.MainActivityViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class CustomerModule {
    @Binds
    abstract fun bindsCustomerRepository(customerRepositoryImpl: CustomerRepositoryImpl): CustomerRepository
    @Binds
    abstract fun bindsCustomerActivityViewModel(viewModel: CustomerActivityViewModel): ViewModel
}