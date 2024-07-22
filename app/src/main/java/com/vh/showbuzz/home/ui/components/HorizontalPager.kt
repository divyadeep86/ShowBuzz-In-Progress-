package com.vh.showbuzz.home.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.vh.showbuzz.common.uiComponents.AsyncImageLoader
import com.vh.showbuzz.home.movieList.domain.Movie
import kotlin.math.absoluteValue

@Composable
fun HorizontalPager(movie: List<Movie>){
    val pagerState = rememberPagerState(pageCount = {
        movie.size
    })
    val imageHeight = LocalConfiguration.current.screenHeightDp * 0.35f
    androidx.compose.foundation.pager.HorizontalPager(state = pagerState) { page ->
        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

                    // We animate the alpha, between 50% and 100%
                    alpha = androidx.compose.ui.util.lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {

            AsyncImageLoader(imageUrl = movie[page].poster_path, Modifier.fillMaxWidth()
                .height(imageHeight.dp),
            contentScale = ContentScale.Fit, showBlurrBg = true )
        }
    }
}