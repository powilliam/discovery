package com.powilliam.discovery.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ApolloClientModule {

    @Singleton
    @Provides
    fun providesApolloClient(
        @AuthenticationInterceptorOkHttpClient okHttpClient: OkHttpClient
    ): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://api.github.com/graphql")
            .okHttpClient(okHttpClient)
            .build()
    }
}