package com.vh.showbuzz.home.movieList.common.di

import com.vh.showbuzz.home.movieList.common.data.MovieListApi
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object MovieListModule {

    @Singleton
    @Provides
    fun provideMovieLisApi(retrofit: Retrofit): MovieListApi {
        return retrofit.create(MovieListApi::class.java)
    }

}