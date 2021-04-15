package com.powilliam.discovery.di

import com.powilliam.discovery.domain.network.interceptors.AuthenticationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthenticationInterceptorOkHttpClient


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @AuthenticationInterceptorOkHttpClient
    @Provides
    fun providesAuthenticationInterceptorOkHttpClient(
        authenticationInterceptor: AuthenticationInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authenticationInterceptor)
            .build()
    }
}