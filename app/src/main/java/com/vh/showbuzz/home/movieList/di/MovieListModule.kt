package com.vh.showbuzz.home.movieList.di

import com.vh.showbuzz.home.movieList.data.MovieListApi
import com.vh.showbuzz.home.movieList.data.MovieListRepo
import com.vh.showbuzz.home.movieList.data.UpcomingMoviesRepo
import com.vh.showbuzz.home.movieList.domain.MovieListUseCase
import com.vh.showbuzz.home.movieList.domain.UpcomingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MovieListModule {
    @Singleton
    @Provides
    fun provideMovieLisApi(retrofit: Retrofit): MovieListApi {
        return retrofit.create(MovieListApi::class.java)
    }
    @Singleton
    @Provides
    fun provideMovieListRepository(movieListApi: MovieListApi): MovieListRepo {
        return MovieListRepo(movieListApi)
    }

    @Singleton
    @Provides
    fun provideMovieListUseCase(moviewListRepo: MovieListRepo): MovieListUseCase {
        return MovieListUseCase(moviewListRepo)
    }

    @Singleton
    @Provides
    fun provideUpComingMovieRepository(movieListApi: MovieListApi): UpcomingMoviesRepo {
        return UpcomingMoviesRepo(movieListApi)
    }
    @Singleton
    @Provides
    fun provideUpcomigMoviesUseCase(upcomingMoviesRepo: UpcomingMoviesRepo): UpcomingMoviesUseCase {
        return UpcomingMoviesUseCase(upcomingMoviesRepo)
    }
}