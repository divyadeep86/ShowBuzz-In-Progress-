package com.vh.showbuzz.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val paddingSmall: Dp = 5.dp,
    val paddingMedium: Dp = 10.dp,
    val paddingMediumLarge: Dp = 16.dp,
    val paddingLarge: Dp = 20.dp,
    val spaceSmall: Dp = 5.dp,
    val spaceMedium: Dp = 10.dp,
    val spaceLarge: Dp = 20.dp,
    val spaceXLarge: Dp = 30.dp,
    val spaceXXLarge: Dp = 40.dp,
    val barHeightSmall: Dp = 30.dp,
    val barHeightMedium: Dp = 40.dp,
    val barHeight: Dp = 60.dp,
    val barHeightX: Dp = 70.dp,
    val bottomBar: Dp = 80.dp,
    val buttonHeight: Dp = 48.dp
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }