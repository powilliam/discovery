package com.powilliam.discovery.domain.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "bearer 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")
            .build()

        return chain.proceed(request)
    }
}