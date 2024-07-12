package com.vh.showbuzz.home.movieList.nowPlaying.domain

import androidx.paging.PagingData
import androidx.paging.map
import com.vh.showbuzz.home.movieList.nowPlaying.data.NowPlayingRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NowPlayingUseCase(private val nowPlayingRepo: NowPlayingRepo) {

    fun nowPlayingMovies(): Flow<PagingData<Movie>> =
        nowPlayingRepo.getNowPlayingMovies().map { list -> list.map { it.toMovie() } }

}