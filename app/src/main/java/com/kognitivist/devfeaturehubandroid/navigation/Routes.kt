package com.kognitivist.devfeaturehubandroid.navigation

import com.kognitivist.devfeaturehubandroid.tools.FeatureCategory
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
	@Serializable
	data object FeatureCategories: Routes()
	@Serializable
	data class FeaturesScreen(val category: FeatureCategory): Routes()
	@Serializable
	sealed class Features: Routes(){
		@Serializable
		data object CustomTheme: Features()
		@Serializable
		data object Material3Theme: Features()
	}

}