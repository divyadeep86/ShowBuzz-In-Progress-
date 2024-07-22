package com.vh.showbuzz.common.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
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
                    .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiNDNjYThjNzY1YmI5MThlMDdiMjhmNGVjNzM5ZDg2YiIsInN1YiI6IjVkMTIzNjlkOTI1MTQxNTI0ZGMwZWY5OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0ioH55ly0oPTXEw5jaGp6CETKpNXrhZlNs0DS2yrd9k")
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