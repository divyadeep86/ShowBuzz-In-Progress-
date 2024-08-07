package com.vh.showbuzz.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.vh.showbuzz.common.uiComponents.AsyncImageLoader
import com.vh.showbuzz.common.uiComponents.CustomProgressBarWithText
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.ui.theme.AppTheme
import kotlin.math.absoluteValue

@Composable
fun HorizontalPagerWithBgImage(movie: List<Movie>) {
    val pagerState = rememberPagerState(pageCount = {
        movie.size
    })
    val height = LocalConfiguration.current.screenHeightDp * 0.35f
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
    ) {


        androidx.compose.foundation.pager.HorizontalPager(state = pagerState) { page ->

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)

                    .background(color = AppTheme.colors.background)

                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                        // We animate the alpha, between 50% and 100%
                        alpha = androidx.compose.ui.util.lerp(
                            start = 0.5f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }) {
                AsyncImageLoader(
                    imageUrl = movie[page].poster_path, modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
                MoviePagerItem(movie = movie[page], height = height.dp) {

                }

            }


        }

    }
}