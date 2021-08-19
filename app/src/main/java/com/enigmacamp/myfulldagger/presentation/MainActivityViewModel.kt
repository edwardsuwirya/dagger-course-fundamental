package com.enigmacamp.myfulldagger.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myfulldagger.data.entity.Customer
import com.enigmacamp.myfulldagger.data.repository.CustomerRepository
import com.enigmacamp.simplesharedpref.data.api.request.AuthenticationRequest
import com.enigmacamp.simplesharedpref.data.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val customerRepository: CustomerRepository
) : ViewModel() {
    fun doLogin(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val isAuthenticated =
                authenticationRepository.login(AuthenticationRequest(userName, password))
            if (isAuthenticated) {
                customerRepository.registerNewCustomer(
                    Customer(
                        name = "Jeco",
                        idCard = "123",
                        gender = "L"
                    )
                )
            }
            Log.d("ViewModel", "doLogin: ${isAuthenticated}")
        }

    }
}