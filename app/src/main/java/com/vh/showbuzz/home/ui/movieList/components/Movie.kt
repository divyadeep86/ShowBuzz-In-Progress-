package com.vh.showbuzz.home.ui.movieList.components;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vh.showbuzz.common.AsyncImageLoader
import com.vh.showbuzz.home.movieList.nowPlaying.domain.Movie


@Composable
 fun Movie(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = { onMovieClick(movie) }),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageHeight = LocalConfiguration.current.screenHeightDp * 0.2f
        AsyncImageLoader(
            imageUrl = movie.poster_path,
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight.dp),
            contentScale = ContentScale.Fit
        )
        Text(text = movie.title)
    }
}

@Preview
@Composable
private fun MoviePreview() {
    Movie(movie = Movie.getPreviewData(), {})
}