package com.enigmacamp.myfulldagger.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myfulldagger.data.api.request.AuthenticationRequest
import com.enigmacamp.myfulldagger.data.entity.Customer
import com.enigmacamp.myfulldagger.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldagger.data.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val customerRepository: CustomerRepository
) : ViewModel() {
    fun doLogin(userName: String, password: String) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val isAuthenticated =
                    authenticationRepository.login(AuthenticationRequest(userName, password))
                if (isAuthenticated) {
                    customerRepository.registerNewCustomer(
                        Customer(
                            name = userName,
                            idCard = "",
                            gender = ""
                        )
                    )
                    Log.d("ViewModel", "doLogin: $isAuthenticated")
                } else {
                    Log.e("ViewModel", "doLogin: Unauthorized")
                }

            }
        } catch (e: Exception) {
            Log.e("ViewModel", e.toString())
        }

    }
}