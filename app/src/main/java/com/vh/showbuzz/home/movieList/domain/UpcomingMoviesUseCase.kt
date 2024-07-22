package com.vh.showbuzz.home.movieList.domain

import androidx.paging.PagingData
import androidx.paging.map
import com.vh.showbuzz.home.movieList.data.MovieListRepo
import com.vh.showbuzz.home.movieList.data.MovieType
import com.vh.showbuzz.home.movieList.data.UpcomingMoviesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UpcomingMoviesUseCase (private val upcomingMoviesRepo: UpcomingMoviesRepo) {

    fun getMovieList(movieType: MovieType): Flow<PagingData<Movie>> =
        upcomingMoviesRepo.getMovies(movieType = movieType).map { list -> list.map { it.toMovie() } }

}