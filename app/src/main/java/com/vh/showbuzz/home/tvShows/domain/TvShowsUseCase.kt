package com.vh.showbuzz.home.tvShows.domain

import androidx.paging.PagingData
import androidx.paging.map
import com.vh.showbuzz.home.tvShows.data.TvShowType
import com.vh.showbuzz.home.tvShows.data.TvShowsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TvShowsUseCase(private val tvShowsRepo: TvShowsRepo) {

    fun getTvShowList(tvShowType: TvShowType): Flow<PagingData<TvShow>> =
        tvShowsRepo.getTvShows(tvShowType = tvShowType).map { list -> list.map { it.toTvShow() } }
}