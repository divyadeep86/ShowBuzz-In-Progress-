package com.vh.showbuzz.common.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.vh.showbuzz.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Dispatcher
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor {
                chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .header("Accept", "application/json")
                    .header("Authorization","Bearer ${BuildConfig.AUTH_TOKEN}")
                    .build())
        }.dispatcher(dispatcher).connectTimeout(
            NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            .callTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS).build()

    }

    @Provides
    @Singleton
    fun provideRetrofitObject( httpClient: OkHttpClient):Retrofit{
        val json = Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            prettyPrint = true
            coerceInputValues = true
        }

        val contentType = "application/json".toMediaType()
        // For simplicity in this assignment we are passing baseUrl directly here but base Url can be fetch from local.properties which is more secure way.
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").client(httpClient)
            .addConverterFactory(json.asConverterFactory(contentType)).build()
    }

}
const val NETWORK_TIMEOUT = 30000L