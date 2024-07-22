package com.vh.showbuzz.home.tvShows.di

import com.vh.showbuzz.home.tvShows.data.TvShowsApi
import com.vh.showbuzz.home.tvShows.data.TvShowsRepo
import com.vh.showbuzz.home.tvShows.domain.TvShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TvShowsModule {

    @Singleton
    @Provides
    fun provideTvShowsApi(retrofit: Retrofit): TvShowsApi {
        return retrofit.create(TvShowsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(tvShowsApi: TvShowsApi): TvShowsRepo {
        return TvShowsRepo(tvShowsApi)
    }

    @Singleton
    @Provides
    fun provideTvShowsUseCase(tvShowsRepo: TvShowsRepo): TvShowsUseCase
    {
        return TvShowsUseCase(tvShowsRepo)
    }
}