package com.vh.showbuzz.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.ui.MovieListViewModel
import com.vh.showbuzz.home.tvShows.domain.TvShow
import com.vh.showbuzz.home.tvShows.ui.TvShowsViewModel
import com.vh.showbuzz.home.ui.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavHost(navHostController: NavHostController,modifier: Modifier) {

    NavHost(navController = navHostController, startDestination = Home) {
        composable<Home> {
            val movieListViewModel = hiltViewModel<MovieListViewModel>()
            val tvShowsViewModel = hiltViewModel<TvShowsViewModel>()
            val popularMoviesPagingData = movieListViewModel.popularMovies.collectAsLazyPagingItems()
            val popularMovies = popularMoviesPagingData.itemSnapshotList.items.take(10)
            HomeScreen(
                nowPlayingMovies = movieListViewModel.nowPlayingMovies.collectAsLazyPagingItems(),
                upcomingMovie = movieListViewModel.upcomingMovie.collectAsLazyPagingItems(),
                popularMovies = popularMoviesPagingData,
                topRatedMovies = movieListViewModel.topRatedMovies.collectAsLazyPagingItems(),
                popularTvShows = tvShowsViewModel.popularTvShows.collectAsLazyPagingItems(),
                topRatedTvShows = tvShowsViewModel.topRatedTvShows.collectAsLazyPagingItems(),
                popularList = popularMovies,
                onMovieSelected = {}
            ) {

            }
        }
        composable<Movie> {

        }
        composable<TvShow> {  }
    }
}

@Serializable
object Home
