package com.vh.showbuzz.home.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.ui.MovieListPane
import com.vh.showbuzz.home.tvShows.domain.TvShow
import com.vh.showbuzz.home.ui.components.HorizontalPagerWithBgImage
import com.vh.showbuzz.ui.theme.AppTheme

@Composable
fun HomeScreen(
    nowPlayingMovies: LazyPagingItems<Movie>,
    upcomingMovie: LazyPagingItems<Movie>,
    popularMovies: LazyPagingItems<Movie>,
    topRatedMovies: LazyPagingItems<Movie>,
    popularList: List<Movie>,
    popularTvShows: LazyPagingItems<TvShow>,
    topRatedTvShows: LazyPagingItems<TvShow>,
    onMovieSelected: (Movie) -> Unit,
    onTvShowSelected: (TvShow) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
    ) {
        item {
            HorizontalPagerWithBgImage(movie = popularList)
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .graphicsLayer { shadowElevation = 2.dp.toPx() }
            )
        }
        val list = listOf(
            MovieCategory.NOW_PLAYING to nowPlayingMovies,
            MovieCategory.UPCOMING to upcomingMovie,
            MovieCategory.POPULAR to popularMovies,
            MovieCategory.TOP_RATED to topRatedMovies
        )
        items(list.size) {
            val (category, movieList) = list[it]
            MovieListPane(categoryName = category, movieList = movieList)
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .graphicsLayer { shadowElevation = 2.dp.toPx() }
            )
        }
        item {
            HorizontalDivider(
                color = Color.Transparent,
                thickness = 50.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
        /* item { MovieListPane(categoryName = MovieCategory.NOW_PLAYING,movieList = nowPlayingMovies)
             VerticalDivider(
                 color = Color.Gray,
                 thickness = 1.dp,
                 modifier = Modifier.fillMaxWidth()
             )
         }

         item {MovieListPane(categoryName = MovieCategory.UPCOMING,movieList = upcomingMovie)  }
         item { MovieListPane(categoryName = MovieCategory.POPULAR,movieList = popularMovies) }
         item { MovieListPane(categoryName = MovieCategory.TOP_RATED,movieList = topRatedMovies) }*/
    }


}

enum class MovieCategory(val displayName: String) {
    NOW_PLAYING("Now Playing"),
    UPCOMING("Upcoming"),
    POPULAR("Popular"),
    TOP_RATED("Top Rated")
}