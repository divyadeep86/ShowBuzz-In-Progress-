package com.vh.showbuzz.common

import android.util.Log
import androidx.compose.foundation.layout.Box

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation


@Composable
fun AsyncImageLoader(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale,
    circleCropTransformation: Boolean = false
) {
    Box(modifier = modifier) {
        AsyncImage(
            modifier = modifier.blur(
                radiusX = 20.dp,
                radiusY = 20.dp
            ),
            model =  ImageRequest.Builder(
                LocalContext.current
            ).data(imageUrl).build(),
            onError = {
                Log.e("ErrorInImageLoader", "${it.result.throwable.message}")
            },
            contentDescription = "loading_image_bg",
            contentScale = ContentScale.Crop,

            )
        AsyncImage(
            modifier = modifier,
            model = if (circleCropTransformation) ImageRequest.Builder(LocalContext.current)
                .data(imageUrl).transformations(CircleCropTransformation())
                .build() else ImageRequest.Builder(
                LocalContext.current
            ).data(imageUrl).build(),
            onError = {
                Log.e("ErrorInImageLoader", "${it.result.throwable.message}")
            },
            contentDescription = "loading_image",
            contentScale = contentScale,

            )
    }

}

