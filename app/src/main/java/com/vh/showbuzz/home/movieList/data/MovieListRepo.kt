package com.vh.showbuzz.home.movieList.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow


class MovieListRepo(private val movieListApi: MovieListApi) {

    fun getMovies(movieType: MovieType): Flow<PagingData<MovieDTO>> {
        return Pager(config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { MovieListPagingSource(movieListApi, movieType = movieType) }).flow
    }
}