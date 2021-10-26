package com.enigmacamp.myfulldagger.data.api.interceptor

import android.util.Log
import com.enigmacamp.myfulldagger.data.SharedPref
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import javax.inject.Inject

class AuthTokenInterceptor @Inject constructor(private val sharedPref: SharedPref) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        Log.d("Interceptor", "intercept: ${originalRequest.url()}")
        try {
            if (!originalRequest.url().toString().contains("login")) {
                Log.d("Interceptor", "intercept:")
                val token = sharedPref.retrieved("token")
                if (token != null) {
                    val requestBuilder = originalRequest.newBuilder()
                        .header("Authorization", token)
                    val request = requestBuilder.build()
                    return chain.proceed(request)
                } else {
                    return Response.Builder()
                        .request(originalRequest)
                        .protocol(Protocol.HTTP_1_1)
                        .code(401)
                        .message("Token Invalid")
                        .body(ResponseBody.create(null, "Token Invalid")).build()
                }

            }
            return chain.proceed(originalRequest)
        } catch (e: Exception) {
            return Response.Builder()
                .request(originalRequest)
                .protocol(Protocol.HTTP_1_1)
                .code(500)
                .message(e.message.toString())
                .body(ResponseBody.create(null, "{${e}}")).build()
        }
    }

}