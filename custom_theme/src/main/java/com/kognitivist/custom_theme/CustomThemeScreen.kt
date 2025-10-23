package com.kognitivist.custom_theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.LocalActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun CustomThemeScreen() {
	val activity = LocalActivity.current as ComponentActivity
	var themeState by rememberSaveable { mutableStateOf(CustomThemes.LIGHT.name) }
	val colors = CustomThemes.valueOf(themeState).colors
	val typography = CustomThemes.valueOf(themeState).typography
	LaunchedEffect(themeState) {
		activity.enableEdgeToEdge(
			statusBarStyle = SystemBarStyle.auto(Color.Transparent.toArgb(), Color.Transparent.toArgb()){
				colors.isLightSystemBarIcons
			},
			navigationBarStyle = SystemBarStyle.auto(Color.Transparent.toArgb(), Color.Transparent.toArgb()){
				colors.isLightSystemBarIcons
			}
		)
	}
	CustomAppTheme(
		colors = colors,
		typography = typography
	) {
		Column(
			modifier = Modifier.fillMaxSize()
				.background(Theme.colors.background)
				.windowInsetsPadding(WindowInsets.systemBars)
				.padding(16.dp)
		) {
				CustomThemes.entries.forEach { theme ->
					Box(
						modifier = Modifier
							.fillMaxWidth()
							.height(48.dp)
							.clickable{ themeState = theme.name }
							.background(Theme.colors.button, RoundedCornerShape(8.dp))
							.padding(vertical = 16.dp),
						contentAlignment = Alignment.Center
					) {
						Text(
							text = theme.name,
							color = Theme.colors.textOnButton,
							style = Theme.typography.default16
						)
					}
					Spacer(Modifier.height(16.dp))
				}
		}
	}
}