package com.vh.showbuzz.home.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vh.showbuzz.R
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.ui.components.Movie

@Composable
fun MoviePagerItem(modifier: Modifier,movie: Movie,onClick:(Movie)->Unit) {
Box(modifier = modifier.width(IntrinsicSize.Max).height(IntrinsicSize.Max)){
    AsyncImage(
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .blur(radiusX = 15.dp, radiusY = 15.dp),
        model =  ImageRequest.Builder(
            LocalContext.current
        ).data(movie.poster_path).build(),
        onError = {
            Log.e("ErrorInImageLoader", "${it.result.throwable.message}")
        },
        error = painterResource(R.drawable.error_image_24),
        contentDescription = "sponsor_image",
        contentScale = ContentScale.Crop,

        )
    Movie(movie = movie, modifier=Modifier.padding(8.dp).align(Alignment.CenterStart),onMovieClick = onClick)
}

}