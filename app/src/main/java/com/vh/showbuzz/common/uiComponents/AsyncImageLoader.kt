package com.vh.showbuzz.common.uiComponents

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.vh.showbuzz.R
import com.vh.showbuzz.common.utils.applyIf
import com.vh.showbuzz.home.movieList.ui.components.Movie


@Composable
fun AsyncImageLoader(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale=ContentScale.Crop,
    circleCropTransformation: Boolean = false,
    showBlurrBg: Boolean = false
) {

    AsyncImage(
        modifier = modifier
            .applyIf(showBlurrBg) {blur(radiusX = 15.dp, radiusY = 15.dp)},
        model =  if (circleCropTransformation) ImageRequest.Builder(LocalContext.current)
            .data(imageUrl).transformations(CircleCropTransformation())
            .build() else ImageRequest.Builder(
            LocalContext.current).data(imageUrl).build(),
        onError = {
            Log.e("ErrorInImageLoader", "${it.result.throwable.message}")
        },
        error = painterResource(R.drawable.error_image_24),
        contentDescription = "sponsor_image",
        contentScale = contentScale,
        )

}

