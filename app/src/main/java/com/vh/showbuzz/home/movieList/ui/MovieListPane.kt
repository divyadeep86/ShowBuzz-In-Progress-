package com.vh.showbuzz.home.movieList.ui;

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.vh.showbuzz.R
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.ui.components.Movie
import com.vh.showbuzz.home.movieList.ui.components.MovieHeader
import com.vh.showbuzz.home.ui.MovieCategory
import com.vh.showbuzz.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun MovieListPane(categoryName: MovieCategory, movieList: LazyPagingItems<Movie>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()

            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,

    ) {
        val listState = rememberLazyListState()
        val visibleIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight().graphicsLayer { if(visibleIndex==0) alpha = 0f else alpha= 1f },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom) {

            Text(
                text = categoryName.displayName,
                style = AppTheme.typography.h4.copy(color = AppTheme.colors.onBackground)
            )
            Icon(modifier = Modifier.size(30.dp),painter = painterResource(id = when(categoryName){
                MovieCategory.NOW_PLAYING -> R.drawable.baseline_local_movies_24
                MovieCategory.UPCOMING -> R.drawable.baseline_upcoming_24
                MovieCategory.POPULAR -> R.drawable.baseline_local_fire_department_24
                MovieCategory.TOP_RATED -> R.drawable.baseline_star_rate_24
            }), contentDescription = "movie icon")
        }


        val middleVisibleItemIndex by remember {
            derivedStateOf {
                val visibleItems = listState.layoutInfo.visibleItemsInfo
                if (visibleItems.isNotEmpty()) {
                    visibleItems[0].index
                } else {
                    -1
                }
                
            }
        }


        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                MovieHeader(categoryName = categoryName)
            }
            items(movieList.itemCount, key = movieList.itemKey { it.id }) { INDEX ->
                val scale = remember { androidx.compose.animation.core.Animatable(1f) }
                LaunchedEffect(middleVisibleItemIndex) {
                    launch {
                        val targetScale = if (INDEX == middleVisibleItemIndex) {
                            Log.d( "MovieListPane: $INDEX","Testst")
                            1f

                        } else{ 0.85f}
                        scale.animateTo(targetScale, animationSpec = tween(durationMillis = 300))
                    }
                }
                Movie(movie = movieList[INDEX]!!, modifier = Modifier.graphicsLayer {
                    scaleX = scale.value
                    scaleY = scale.value
                    alpha = scale.value

                }, onMovieClick = {})
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    if (movieList.loadState.refresh is LoadState.Loading || movieList.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(30.dp)
                        )
                    }

                }
            }

        }


    }


}


