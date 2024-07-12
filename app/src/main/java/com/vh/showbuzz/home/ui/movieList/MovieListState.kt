package com.vh.showbuzz.home.ui.movieList

import androidx.paging.PagingData
import com.vh.showbuzz.home.movieList.nowPlaying.domain.Movie

data class MovieListState(val nowPlayingPagingList:PagingData<Movie> = PagingData.empty())
