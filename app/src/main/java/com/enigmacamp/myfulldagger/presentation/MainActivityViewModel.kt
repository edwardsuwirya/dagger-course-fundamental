package com.enigmacamp.myfulldagger.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.myfulldagger.data.api.request.AuthenticationRequest
import com.enigmacamp.myfulldagger.data.entity.Customer
import com.enigmacamp.myfulldagger.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldagger.data.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
class MainActivityViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val customerRepository: CustomerRepository
) : ViewModel() {
    private var _userIsAuthenticated = MutableLiveData<Boolean>()
    val userIsAuthenticated: LiveData<Boolean>
        get() = _userIsAuthenticated

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
                    _userIsAuthenticated.postValue(true)
                } else {
                    Log.e("ViewModel", "doLogin: Unauthorized")
                    _userIsAuthenticated.postValue(false)
                }

            }
        } catch (e: Exception) {
            Log.e("ViewModel", e.toString())
            _userIsAuthenticated.postValue(false)
        }

    }
}