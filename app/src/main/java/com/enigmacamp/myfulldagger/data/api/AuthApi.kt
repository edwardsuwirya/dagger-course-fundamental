package com.enigmacamp.myfulldagger.data.api

import com.enigmacamp.myfulldagger.data.api.request.AuthenticationRequest
import com.enigmacamp.myfulldagger.data.api.response.AuthenticationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    suspend fun login(@Body authentication: AuthenticationRequest): Response<AuthenticationResponse>
}