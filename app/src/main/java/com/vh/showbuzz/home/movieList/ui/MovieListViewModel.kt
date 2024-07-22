package com.vh.showbuzz.home.movieList.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.map
import com.vh.showbuzz.home.movieList.data.MovieType
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.domain.MovieListUseCase
import com.vh.showbuzz.home.movieList.domain.UpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase,private val upcomingMoviesUseCase: UpcomingMoviesUseCase) :
    ViewModel() {

    val nowPlayingMovies = movieListUseCase.getMovieList(MovieType.NOW_PLAYING).cachedIn(viewModelScope)
    val upcomingMovie = movieListUseCase.getMovieList(MovieType.UPCOMING).cachedIn(viewModelScope)
    val popularMovies = movieListUseCase.getMovieList(MovieType.POPULAR).cachedIn(viewModelScope)
    val topRatedMovies = movieListUseCase.getMovieList(MovieType.TOP_RATED).cachedIn(viewModelScope)



}