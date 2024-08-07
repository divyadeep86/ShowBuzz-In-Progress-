package com.vh.showbuzz.home.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vh.showbuzz.common.uiComponents.AsyncImageLoader
import com.vh.showbuzz.common.uiComponents.CustomProgressBarWithText
import com.vh.showbuzz.common.utils.convertNumberToDouble
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.ui.theme.AppTheme

@Composable
fun MoviePagerItem(movie: Movie,height:Dp,onClick:(Movie)->Unit) {
    with(movie) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                AppTheme.colors.background,
                                AppTheme.colors.background.copy(alpha = 0.85f)
                            )
                        )
                    ).padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                com.vh.showbuzz.home.movieList.ui.components.Movie(movie = movie,
                    onMovieClick = {})
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$title ($release_date)",
                        style = AppTheme.typography.h3.copy(color = AppTheme.colors.onBackground)
                    )

                    Column(
                        modifier = Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomProgressBarWithText(fractionalProgress = prgress, percentageProgress = scorePercentage,showBg = true)
                    }
                }

            }

    }

}