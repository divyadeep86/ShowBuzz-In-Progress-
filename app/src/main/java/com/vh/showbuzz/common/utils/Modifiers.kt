package com.vh.showbuzz.common.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas

fun Modifier.applyIf(condition: Boolean, modifier: Modifier.() -> Modifier): Modifier {
    return if (condition) {
        this.then(modifier(Modifier))
    } else {
        this
    }
}
fun Modifier.foregroundColor(color: Color): Modifier = this.then(
    Modifier.drawBehind {
        val paint = Paint().apply { this.color = color }
        drawIntoCanvas { canvas ->
            canvas.drawRect(size.toRect(), paint)
        }
    }
)