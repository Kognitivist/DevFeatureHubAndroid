package com.kognitivist.custom_theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFAFAFA)
val Black = Color(0xFF000000)

val Red = Color(0xFFD9A8A8)
val InverseRed = Color(0xFF451010)

val Blue = Color(0xFF98C3C7)
val InverseBlue = Color(0xFF143E5C)

@Immutable
class Colors(
	val isLightSystemBarIcons: Boolean,
	val background: Color,
	val button: Color,
	val textOnButton: Color,
)

internal val DarkColors = Colors(
	isLightSystemBarIcons = true,
	background = Black,
	button = White,
	textOnButton = Black
)
internal val LightColors = Colors(
	isLightSystemBarIcons = false,
	background = White,
	button = Black,
	textOnButton = White,
)

internal val RedDarkColors = Colors(
	isLightSystemBarIcons = true,
	background = InverseRed,
	button = Red,
	textOnButton = InverseRed,
)
internal val RedLightColors = Colors(
	isLightSystemBarIcons = false,
	background = Red,
	button = InverseRed,
	textOnButton = Red,
)

internal val BlueDarkColors = Colors(
	isLightSystemBarIcons = true,
	background = InverseBlue,
	button = Blue,
	textOnButton = InverseBlue,
)
internal val BlueLightColors = Colors(
	isLightSystemBarIcons = false,
	background = Blue,
	button = InverseBlue,
	textOnButton = Blue,
)