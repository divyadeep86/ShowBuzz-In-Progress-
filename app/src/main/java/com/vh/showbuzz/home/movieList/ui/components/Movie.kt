package com.vh.showbuzz.home.movieList.ui.components;

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vh.showbuzz.R
import com.vh.showbuzz.common.uiComponents.AsyncImageLoader
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.ui.MovieCategory
import com.vh.showbuzz.ui.theme.AppTheme


@Composable
 fun Movie(movie: Movie,modifier: Modifier = Modifier ,onMovieClick: (Movie) -> Unit) {
    val imageHeight = LocalConfiguration.current.screenHeightDp * 0.30f
    val imageWidth = LocalConfiguration.current.screenHeightDp * 0.20f
    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(CircleShape.copy(CornerSize(12.dp)))
            .clickable(onClick = { onMovieClick(movie) })
    ) {

        AsyncImageLoader(
            imageUrl = movie.poster_path,
            modifier = Modifier
                .width(imageWidth.dp)
                .height(imageHeight.dp),
            contentScale = ContentScale.FillBounds
        )
    }

}
@Composable
fun MovieHeader(categoryName:MovieCategory) {
    val imageHeight = LocalConfiguration.current.screenHeightDp * 0.30f
    val imageWidth = LocalConfiguration.current.screenHeightDp * 0.20f
    Column(
        modifier = Modifier
            .width(imageWidth.dp)
            .height(imageHeight.dp)
            .scale(0.80f)

            .clip(CircleShape.copy(CornerSize(12.dp)))
            .background(color = Color.LightGray.copy(alpha = 0.3f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Text(
            text = categoryName.displayName,
            style = AppTheme.typography.h2.copy(color = AppTheme.colors.onBackground)
        )
        Icon(modifier = Modifier.size(80.dp),painter = painterResource(id = when(categoryName){
             MovieCategory.NOW_PLAYING -> R.drawable.baseline_local_movies_24
             MovieCategory.UPCOMING -> R.drawable.baseline_upcoming_24
             MovieCategory.POPULAR -> R.drawable.baseline_local_fire_department_24
             MovieCategory.TOP_RATED -> R.drawable.baseline_star_rate_24
        }), contentDescription = "movie icon")
    }

}

@Preview
@Composable
private fun MoviePreview() {
   // Movie(movie = Movie.getPreviewData(), {})
}