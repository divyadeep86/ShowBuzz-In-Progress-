package com.vh.showbuzz.home.movieList.ui.components;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vh.showbuzz.common.uiComponents.AsyncImageLoader
import com.vh.showbuzz.home.movieList.domain.Movie


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

@Preview
@Composable
private fun MoviePreview() {
   // Movie(movie = Movie.getPreviewData(), {})
}