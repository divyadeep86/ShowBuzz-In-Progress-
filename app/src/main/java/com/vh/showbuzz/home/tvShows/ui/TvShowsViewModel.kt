package com.vh.showbuzz.home.tvShows.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vh.showbuzz.home.tvShows.data.TvShowType
import com.vh.showbuzz.home.tvShows.domain.TvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(private val tvShowsUseCase: TvShowsUseCase):ViewModel() {

    val popularTvShows = tvShowsUseCase.getTvShowList(TvShowType.POPULAR).cachedIn(viewModelScope)
    val topRatedTvShows = tvShowsUseCase.getTvShowList(TvShowType.TOP_RATED).cachedIn(viewModelScope)
}