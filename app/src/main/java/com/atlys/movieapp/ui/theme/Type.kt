package com.atlys.movieapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val typography = Typography(
        h2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W600,
                fontSize = 48.sp
        ),
        h3 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 36.sp
        ),
        h4 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W600,
                fontSize = 30.sp
        ),
        h5 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W600,
                fontSize = 24.sp
        ),
        h6 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp
        ),
        subtitle1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp
        ),
        subtitle2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
        ),
        body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp
        ),
        body2 = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 14.sp,
                lineHeight = 20.sp
        ),
        button = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
        ),
        caption = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
        ),
        overline = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp

        )
)