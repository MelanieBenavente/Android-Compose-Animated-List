package com.melaniadev.fitcare.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
data class CustomColorsPalette(val customTextColor : Color = Color.Unspecified)

val darkGray = Color(color = 0xFF637587)
val lightGray = Color(color = 0xABFFFFFF)
val lightCustomColorsPalette = CustomColorsPalette(darkGray)
val darkCustomColorsPalette = CustomColorsPalette(lightGray)
val localCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }