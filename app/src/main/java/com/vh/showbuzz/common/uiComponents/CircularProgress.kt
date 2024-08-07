package com.vh.showbuzz.common.uiComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vh.showbuzz.common.utils.applyIf
import com.vh.showbuzz.ui.theme.AppTheme

@Composable
fun CustomProgressBarWithText(
    fractionalProgress: Float,
    percentageProgress:Int,
    progressTrackColor: Color = Color.LightGray,
    progressColor: Color = AppTheme.colors.activated,
    showBg: Boolean = false,
    backgroundColor: Color = Color.DarkGray,
    size: Dp = 70.dp,
    strokeWidth: Dp = 5.dp,
    gapSize:Dp = 0.dp
) {
    Box(modifier = Modifier
        .size(size)
        .applyIf(showBg, modifier = {
            drawBehind {
                drawCircle(
                    color = backgroundColor,
                    radius = size.toPx() / 2,
                    center = center,
                    style = Fill
                )
            }

        }).applyIf(showBg, modifier = {padding(4.dp)})) {
        BasicText(
            modifier = Modifier.align(Alignment.Center),
            text = "$percentageProgress%",
            style = AppTheme.typography.smallBodyText.copy(color = Color.White)
        )
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center).size(size),
            progress = { fractionalProgress },
            trackColor = progressTrackColor,
            color = progressColor,
            strokeWidth = strokeWidth,
            gapSize = gapSize
        )
    }

}