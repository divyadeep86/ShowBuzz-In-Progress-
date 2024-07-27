package com.vh.showbuzz.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.ui.MovieListPane
import com.vh.showbuzz.home.tvShows.domain.TvShow
import com.vh.showbuzz.home.ui.components.HorizontalPagerWithBgImage

@Composable
fun HomeScreen(
    nowPlayingMovies: LazyPagingItems<Movie>,
    upcomingMovie: LazyPagingItems<Movie>,
    popularMovies: LazyPagingItems<Movie>,
    topRatedMovies: LazyPagingItems<Movie>,
    popularList:List<Movie>,
    popularTvShows: LazyPagingItems<TvShow>,
    topRatedTvShows: LazyPagingItems<TvShow>,
    onMovieSelected: (Movie) -> Unit,
    onTvShowSelected: (TvShow) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            HorizontalPagerWithBgImage(movie =popularList)
        }
        item { MovieListPane(categoryName = "Now Playing",movieList = nowPlayingMovies) }
        item {MovieListPane(categoryName = "Upcoming Movies",movieList = upcomingMovie)  }
        item { MovieListPane(categoryName = "Popular Movies",movieList = popularMovies) }
        item { MovieListPane(categoryName = "Top Rated Movies",movieList = topRatedMovies) }
    }


}