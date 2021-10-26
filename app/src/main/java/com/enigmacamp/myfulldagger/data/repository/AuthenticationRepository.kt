package com.enigmacamp.myfulldagger.data.repository

import com.enigmacamp.myfulldagger.data.api.request.AuthenticationRequest


interface AuthenticationRepository {
    suspend fun login(authenticationRequest: AuthenticationRequest): Boolean
    fun retrieveToken(): String?
}