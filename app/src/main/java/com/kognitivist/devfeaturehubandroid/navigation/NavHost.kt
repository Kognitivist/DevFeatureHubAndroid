package com.kognitivist.devfeaturehubandroid.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.navigation.rememberBottomSheetNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kognitivist.custom_theme.CustomThemeScreen
import com.kognitivist.devfeaturehubandroid.tools.Feature
import com.kognitivist.devfeaturehubandroid.tools.FeatureCategory
import com.kognitivist.devfeaturehubandroid.ui.screens.feature_categories_screen.FeatureCategoriesScreen
import com.kognitivist.devfeaturehubandroid.ui.screens.features_screen.FeaturesScreen
import java.nio.file.WatchEvent

val LocalNavigator = staticCompositionLocalOf<NavHostController?> { null }

@Composable
fun NavHostApp() {
	val bottomSheetNavigator = rememberBottomSheetNavigator()
	val controller = rememberNavController(bottomSheetNavigator)

	CompositionLocalProvider(
		LocalNavigator provides controller
	){
		NavHost(
			navController = controller,
			startDestination = Routes.FeatureCategories,
			modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
		) {
			composable<Routes.FeatureCategories> { FeatureCategoriesScreen() }
			composable<Routes.FeaturesScreen> {
				val category = it.toRoute<Routes.FeaturesScreen>().category
				FeaturesScreen(category)
			}
			composable<Routes.Features.CustomTheme> { CustomThemeScreen() }
		}
	}
}