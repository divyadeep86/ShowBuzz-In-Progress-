package com.vh.showbuzz.home.ui.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vh.showbuzz.home.movieList.nowPlaying.domain.NowPlayingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val nowPlayingUseCase: NowPlayingUseCase) :
    ViewModel() {

    val nowPlayingMovies = nowPlayingUseCase.nowPlayingMovies().cachedIn(viewModelScope)



}