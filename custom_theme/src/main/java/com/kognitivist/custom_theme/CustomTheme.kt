package com.kognitivist.custom_theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


private val LocalColors = staticCompositionLocalOf { LightColors }
private val LocalTypography = staticCompositionLocalOf { Typography1 }

@Composable
fun CustomAppTheme(
	colors: Colors = LocalColors.current,
	typography: CustomTypography = LocalTypography.current,
	content: @Composable () -> Unit
) {
	CompositionLocalProvider(
		LocalColors provides colors,
		LocalTypography provides typography,
	) { content() }
}

object Theme {
	val colors: Colors
		@Composable
		get() = LocalColors.current

	val typography: CustomTypography
		@Composable
		get() = LocalTypography.current
}

enum class CustomThemes(
	val colors: Colors,
	val typography: CustomTypography,
)
{
	DARK(
		colors = DarkColors,
		typography = Typography1
	),
	LIGHT(
		colors = LightColors,
		typography = Typography1
	),
	DARK_RED(
		colors = RedDarkColors,
		typography = Typography2
	),
	LIGHT_RED(
		colors = RedLightColors,
		typography = Typography2
	),
	DARK_BLUE(
		colors = BlueDarkColors,
		typography = Typography3
	),
	LIGHT_BLUE(
		colors = BlueLightColors,
		typography = Typography3
	)
}

