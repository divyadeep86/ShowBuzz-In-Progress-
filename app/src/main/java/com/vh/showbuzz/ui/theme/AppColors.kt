package com.vh.showbuzz.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicLightColorScheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

class AppColors(
    primary: Color,
    secondary: Color,
    onPrimary: Color,
    onSecondary: Color,
    background: Color,
    onBackground: Color,
    disabledColor: Color,
    activated: Color,
    switchTrack: Color,
    switchSlider: Color,
    border: Color,
    iconTint: Color,
    error: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var activated by mutableStateOf(activated)
        private set
    var switchTrack by mutableStateOf(switchTrack)
        private set
    var switchSlider by mutableStateOf(switchSlider)
        private set
    var disabledColor by mutableStateOf(disabledColor)
        private set
    var iconTint by mutableStateOf(iconTint)
        private set
    var border by mutableStateOf(border)
        private set
    var error by mutableStateOf(error)
        private set
    var isLight by mutableStateOf(isLight)
        internal set


    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        onPrimary: Color = this.onPrimary,
        onSecondary: Color = this.onSecondary,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        activated: Color = this.activated,
        switchSlider: Color = this.switchSlider,
        switchTrack: Color = this.switchTrack,
        border: Color = this.border,
        disabledColor: Color = this.disabledColor,
        iconTint: Color = this.iconTint,
        error: Color = this.error,
        isLight: Boolean = this.isLight,
    ): AppColors = AppColors(
        primary = primary,
        secondary = secondary,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        background = background,
        onBackground = onBackground,
        activated = activated,
        border = border,
        switchSlider = switchSlider,
        switchTrack = switchTrack,
        disabledColor = disabledColor,
        iconTint = iconTint,
        error = error,
        isLight = isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        secondary = other.secondary
        onPrimary = other.onPrimary
        onSecondary = other.onSecondary
        background = other.background
        onBackground = other.onBackground
        activated = other.activated
        switchTrack = other.switchTrack
        switchSlider = other.switchSlider
        disabledColor = other.disabledColor
        iconTint = other.iconTint
        border = other.border
        error = other.error
        isLight = other.isLight
    }
}

//----------Light theme colors
private val colorLightPrimary = Color(0xFFFF4500)
private val colorLightSecondary = Color(0xFFFFD700)
private val colorLightOnPrimary = Color(0xFFFFFFFF)
private val colorLightOnSecondary = Color(0xFF000000)
private val colorLightBorder = Color(0xFF1B1B1B)
private val colorLightBackground = Color(0xFFFFFFFF)
private val colorLightOnBackground = Color(0xFF000000)
private val colorLightIconTint = Color(0xFF1B1B1B)
private val colorLightSwitchTrack = Color(0xFF949494)
private val colorLightSwitchSlider = Color(0xFFFFFFFF)
private val colorLightError = Color(0xFFD62222)
private val colorUIActivated = Color(0xFF60C56A)
private val colorUIDisabled = Color(0xFFE8E8E8)


//----------Dark theme colors
private val colorDarkPrimary = Color(0xFFFF4500)
private val colorDarkSecondary = Color(0xFFFFD700)
private val colorDarkOnPrimary = Color(0xFF000000)
private val colorDarkOnSecondary = Color(0xFF000000)
private val colorDarkBorder = Color(0xFFC0C0C0)
private val colorDarkIconTint = Color(0xFFBEBEBE)
private val colorDarkBackground = Color(0xFF2E2E2E)
private val colorDarkOnBackground = Color(0xFFFFFFFF)
private val colorDarkSwitchTrack = Color(0xFF494949)
private val colorDarkSwitchSlider = Color(0xFF000000)
private val colorDarkError = Color(0xFFD62222)

fun lightColors(
    primary: Color = colorLightPrimary,
    secondary: Color = colorLightSecondary,
    onPrimary: Color = colorLightOnPrimary,
    onSecondary: Color = colorLightOnSecondary,
    background: Color = colorLightBackground,
    onBackground: Color = colorLightOnBackground,
    border: Color = colorLightBorder,
    activated: Color = colorUIActivated,
    switchTrack: Color = colorLightSwitchTrack,
    switchSlider: Color = colorLightSwitchSlider,
    disabledColor: Color = colorUIDisabled,
    iconTint: Color = colorLightIconTint,
    error: Color = colorLightError,
): AppColors = AppColors(
    primary = primary,
    secondary = secondary,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    background = background,
    onBackground = onBackground,
    activated = activated,
    border = border,
    switchSlider = switchSlider,
    switchTrack = switchTrack,
    disabledColor = disabledColor,
    iconTint = iconTint,
    error = error,
    isLight = true
)

fun darkColors(
    primary: Color = colorDarkPrimary,
    secondary: Color = colorDarkSecondary,
    onPrimary: Color = colorDarkOnPrimary,
    onSecondary: Color = colorDarkOnSecondary,
    background: Color = colorDarkBackground,
    onBackground: Color = colorDarkOnBackground,
    border: Color = colorDarkBorder,
    activated: Color = colorUIActivated,
    switchTrack: Color = colorDarkSwitchTrack,
    switchSlider: Color = colorDarkSwitchSlider,
    disabledColor: Color = colorUIDisabled,
    iconTint: Color = colorDarkIconTint,
    error: Color = colorDarkError,
): AppColors = AppColors(
    primary = primary,
    secondary = secondary,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    background = background,
    onBackground = onBackground,
    activated = activated,
    border = border,
    switchSlider = switchSlider,
    switchTrack = switchTrack,
    disabledColor = disabledColor,
    iconTint = iconTint,
    error = error,
    isLight = false
)

@Composable
fun themeMode(isDarkTheme: Boolean = isSystemInDarkTheme()): AppColors {

      val colorScheme = when {
            /* Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
               val context = LocalContext.current
               if (isDarkTheme) dynamicLightColorScheme(context) else dynamicLightColorScheme(context)
           }*/
        isDarkTheme -> darkColors()
        else -> lightColors()
    }
    // val systemUiController = rememberSystemUiContr()
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as? Activity)?.window?.statusBarColor =
                colorScheme.background.toArgb()
            (view.context as Activity).window?.let {
                WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars =
                    !isDarkTheme
            }

        }
    }
    return colorScheme

}
internal val LocalColors = staticCompositionLocalOf { lightColors() }