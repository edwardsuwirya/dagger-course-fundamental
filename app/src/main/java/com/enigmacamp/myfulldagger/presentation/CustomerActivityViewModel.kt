package com.enigmacamp.myfulldagger.presentation

import androidx.lifecycle.ViewModel
import com.enigmacamp.myfulldagger.data.repository.CustomerRepository
import javax.inject.Inject

class CustomerActivityViewModel @Inject constructor(
    private val customerRepository: CustomerRepository
) : ViewModel() {
}