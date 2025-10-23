package com.kognitivist.custom_theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CustomTypography(
	val default16: TextStyle,
)

val Typography1 = CustomTypography(
	default16 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp
	)
)
val Typography2 = CustomTypography(
	default16 = TextStyle(
		fontFamily = FontFamily.Cursive,
		fontWeight = FontWeight.Black,
		fontSize = 16.sp
	)
)
val Typography3 = CustomTypography(
	default16 = TextStyle(
		fontFamily = FontFamily.Monospace,
		fontWeight = FontWeight.Thin,
		fontSize = 16.sp
	)
)