package com.kognitivist.devfeaturehubandroid.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kognitivist.custom_theme.CustomThemeScreen
import com.kognitivist.devfeaturehubandroid.navigation.NavHostApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			NavHostApp()
		}
	}
}