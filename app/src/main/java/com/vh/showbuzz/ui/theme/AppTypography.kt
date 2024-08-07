package com.vh.showbuzz.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vh.showbuzz.R

private val RobotoRegular =  FontFamily(
    Font(R.font.roboto_slab, FontWeight.Normal)
)

private val RobotoCondensedRegular =  FontFamily(
    Font(R.font.roboto_condensed_regular, FontWeight.Normal)
)

private val RobotoCondensedLight =  FontFamily(
    Font(R.font.roboto_condensed_light, FontWeight.Normal)
)

private val Bebas_neue =  FontFamily(
    Font(R.font.bebas_neue, FontWeight.Normal)
)
@Immutable
data class AppTypography(
    val  h1: TextStyle = TextStyle(
        fontFamily = Bebas_neue,
        fontWeight = FontWeight.Black,
        fontSize = 40.sp
    ),
    val  h2: TextStyle = TextStyle(
        fontFamily = Bebas_neue,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),
    val  h3: TextStyle = TextStyle(
        fontFamily = Bebas_neue,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
    ),
    val  h4: TextStyle = TextStyle(
        fontFamily = Bebas_neue,
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
    ),
    val  bodyText: TextStyle = TextStyle(
        fontFamily = RobotoCondensedLight,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp,
        fontSize = 16.sp,
    ),
    val  smallBodyText: TextStyle = TextStyle(
        fontFamily = RobotoCondensedLight,
        fontWeight = FontWeight.Medium,
        lineHeight = 14.sp,
        fontSize = 14.sp,
    )
)
internal val LocalTypography = staticCompositionLocalOf { AppTypography() }

