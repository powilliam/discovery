package com.powilliam.discovery.domain.network.clients

import com.apollographql.apollo.ApolloClient
import com.powilliam.discovery.di.AuthenticationInterceptorOkHttpClient
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Apollo @Inject constructor(
    @AuthenticationInterceptorOkHttpClient private val okHttpClient: OkHttpClient
) {
    fun getClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://api.github.com/graphql")
            .okHttpClient(okHttpClient)
            .build()
    }
}