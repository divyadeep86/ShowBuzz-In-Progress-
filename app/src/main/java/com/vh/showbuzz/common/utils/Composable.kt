package com.vh.showbuzz.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.toPx(): Float {
    val density = LocalDensity.current
    return with(density) { toPx() }
}
