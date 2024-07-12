package com.vh.showbuzz.home.genres.di

import com.vh.showbuzz.home.genres.data.GenresMoviesRepo
import com.vh.showbuzz.home.genres.domain.GenresMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object GenresModule {

    @Singleton
    @Provides
    fun provideGenresMoviesUseCase(genresMoviesRepo: GenresMoviesRepo): GenresMoviesUseCase {
        return GenresMoviesUseCase(genresMoviesRepo = genresMoviesRepo)
    }

    @Singleton
    @Provides
    fun provideGenresTVUseCase(genresMoviesRepo: GenresMoviesRepo): GenresMoviesUseCase {
        return GenresMoviesUseCase(genresMoviesRepo = genresMoviesRepo)
    }
}