package com.kognitivist.devfeaturehubandroid.ui.screens.features_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kognitivist.custom_theme.Theme
import com.kognitivist.devfeaturehubandroid.navigation.LocalNavigator
import com.kognitivist.devfeaturehubandroid.tools.Feature
import com.kognitivist.devfeaturehubandroid.tools.FeatureCategory

@Composable
fun FeaturesScreen(category: FeatureCategory) {
	val navigator = LocalNavigator.current

	LazyColumn(
		contentPadding = PaddingValues(16.dp)
	) {
		items(Feature.getFeaturesFromCategory(category)){ feature ->
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(48.dp)
					.clickable{  }
					.background(Theme.colors.button, RoundedCornerShape(8.dp))
					.padding(vertical = 16.dp),
				contentAlignment = Alignment.Center
			) {
				Text(
					text = feature.name,
					color = Theme.colors.textOnButton,
					style = Theme.typography.default16
				)
			}
			Spacer(Modifier.height(16.dp))
		}
	}
}