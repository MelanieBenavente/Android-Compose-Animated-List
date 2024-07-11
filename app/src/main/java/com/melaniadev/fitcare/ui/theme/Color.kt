package com.melaniadev.fitcare.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val primaryBlue = Color(color = 0XFF498c8e)
val secondaryBlue = Color(color = 0XFFA2DBE0)
val grayComponentsBackground = Color(color = 0xFFF0F2F5)
data class CustomColorsPalette(val customTextColor: Color = Color.Unspecified, val customButtonTextColor: Color = Color.Unspecified)
//dark colors
val darkGray = Color(color = 0xFF637587)
val black = Color.Black


//light colors
val lightGray = Color(color = 0xABFFFFFF)
val white = Color.White

// dark and light palettes
val darkThemeCustomPalette = CustomColorsPalette(
    customTextColor = lightGray, customButtonTextColor = black)

val lightThemeCustomPalette = CustomColorsPalette(
    customTextColor = darkGray, customButtonTextColor = white)

///////////////* Custom Palette *///////////////
val localCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }