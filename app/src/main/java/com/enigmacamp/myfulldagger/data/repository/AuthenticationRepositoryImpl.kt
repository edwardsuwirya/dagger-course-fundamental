package com.enigmacamp.myfulldagger.data.repository

import com.enigmacamp.myfulldagger.data.SharedPref
import com.enigmacamp.myfulldagger.data.api.AuthApi
import com.enigmacamp.myfulldagger.data.api.request.AuthenticationRequest
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val sharedPref: SharedPref
) :
    AuthenticationRepository {
    override suspend fun login(authenticationRequest: AuthenticationRequest): Boolean {
        val response = authApi.login(authenticationRequest)
        if (response.isSuccessful) {
            val result = response.body().let {
//                Log.d("Repo", "loginRes: ${it.token}")
                if (it != null) {
                    sharedPref.save(TOKEN, it.token)
                    true
                } else {
                    false
                }
            }
            return result
        }
        return false
    }

    override fun retrieveToken(): String? {
        return sharedPref.retrieved(TOKEN)
    }

    companion object {
        private const val TOKEN = "token"
    }
}