package com.enigmacamp.myfulldagger.di.app

import com.enigmacamp.myfulldagger.BuildConfig
import com.enigmacamp.myfulldagger.data.api.AuthApi
import com.enigmacamp.myfulldagger.data.api.interceptor.AuthTokenInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    private val BASE_URL: String = BuildConfig.API_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(authTokenIntercept: AuthTokenInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authTokenIntercept)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun authApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}