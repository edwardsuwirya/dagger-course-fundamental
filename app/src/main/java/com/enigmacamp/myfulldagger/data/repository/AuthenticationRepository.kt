package com.enigmacamp.simplesharedpref.data.repository

import com.enigmacamp.simplesharedpref.data.api.request.AuthenticationRequest

interface AuthenticationRepository {
    suspend fun login(authenticationRequest: AuthenticationRequest): Boolean
    fun retrieveToken(): String?
}