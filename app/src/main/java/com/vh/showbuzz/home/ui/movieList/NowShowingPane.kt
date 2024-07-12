package com.vh.showbuzz.home.ui.movieList;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.vh.showbuzz.home.movieList.nowPlaying.domain.Movie
import com.vh.showbuzz.home.ui.movieList.components.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NowShowingPane(nowShowingMovies: LazyPagingItems<Movie>) {
    val isRefreshing = remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize()

    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(nowShowingMovies.itemCount, key = nowShowingMovies.itemKey { it.id }) { INDEX ->
                Movie(movie = nowShowingMovies[INDEX]!!, onMovieClick = {})
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (nowShowingMovies.loadState.refresh is LoadState.Loading || nowShowingMovies.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(30.dp)
                        )
                    }

                }
            }

        }


    }
}



