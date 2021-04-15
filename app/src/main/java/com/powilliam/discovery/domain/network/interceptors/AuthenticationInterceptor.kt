package com.powilliam.discovery.domain.network.interceptors

import com.powilliam.discovery.BuildConfig
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
            .addHeader("Authorization", "bearer ${BuildConfig.GITHUB_API_TOKEN}")
            .build()

        return chain.proceed(request)
    }
}