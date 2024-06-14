package com.melaniadev.fitcare.ui.theme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.melaniadev.fitcare.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.lexend_bold)),
        fontWeight = FontWeight.Normal,
        lineHeight = 27.5.sp,
        fontSize = 22.sp,
        letterSpacing = (-1).sp
    ),
    titleLarge =  TextStyle(
        fontFamily = FontFamily(Font(R.font.lexend_bold)),
        fontWeight = FontWeight.Thin,
        lineHeight = 22.5.sp,
        fontSize = 18.sp,
        letterSpacing = (0).sp
    ),

    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.lexend)),
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        fontSize = 16.sp,
        color = Color.LightGray,
        letterSpacing = 0.sp
    )

/* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)