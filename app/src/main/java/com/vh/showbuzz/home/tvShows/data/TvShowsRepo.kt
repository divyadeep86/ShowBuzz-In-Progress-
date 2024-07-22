package com.vh.showbuzz.home.tvShows.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class TvShowsRepo(private val tvShowsApi: TvShowsApi) {

    fun getTvShows(tvShowType: TvShowType): Flow<PagingData<TVShowDTO>> {
        return Pager(config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = {
                TvShowsPagingSource(
                    tvShowsApi = tvShowsApi,
                    tvShowType = tvShowType
                )
            }).flow
    }
}