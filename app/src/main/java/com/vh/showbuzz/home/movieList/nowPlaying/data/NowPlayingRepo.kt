package com.vh.showbuzz.home.movieList.nowPlaying.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vh.showbuzz.home.movieList.common.data.MovieDTO
import com.vh.showbuzz.home.movieList.common.data.MovieListApi
import kotlinx.coroutines.flow.Flow


class NowPlayingRepo(private val movieListApi: MovieListApi) {

    fun getNowPlayingMovies(): Flow<PagingData<MovieDTO>> {
        return Pager(config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { NowPlayingPagingSource(movieListApi) }).flow
    }
}