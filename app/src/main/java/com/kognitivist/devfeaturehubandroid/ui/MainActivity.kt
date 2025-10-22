package com.kognitivist.devfeaturehubandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kognitivist.custom_theme.ScreenCustomTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			ScreenCustomTheme()
		}
	}
}