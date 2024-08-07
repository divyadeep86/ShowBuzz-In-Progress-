package com.vh.showbuzz.home.movieList.domain

import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.map
import com.vh.showbuzz.common.utils.getCurrentDate
import com.vh.showbuzz.common.utils.toDate
import com.vh.showbuzz.home.movieList.data.MovieListRepo
import com.vh.showbuzz.home.movieList.data.MovieType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieListUseCase(private val movieListRepo: MovieListRepo) {

    fun getMovieList(movieType: MovieType): Flow<PagingData<Movie>> =
        movieListRepo.getMovies(movieType = movieType).map { list -> list.map { it.toMovie() }.filter {
            if (movieType == MovieType.UPCOMING) {
                it.release_date != null && it.release_date.toDate()!!.after(getCurrentDate())
            } else {
                true
            }
        } }

}