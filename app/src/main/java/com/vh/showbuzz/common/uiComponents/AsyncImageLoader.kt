package com.vh.showbuzz.common.uiComponents

import android.util.Log

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.vh.showbuzz.R


@Composable
fun AsyncImageLoader(
    imageUrl: String,
    modifier: Modifier,
    contentScale: ContentScale,
    circleCropTransformation: Boolean = false
) {

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
        error = painterResource(R.drawable.error_image_24),
        contentDescription = "sponsor_image",
        contentScale = contentScale,

        )
}

