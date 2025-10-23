package com.kognitivist.devfeaturehubandroid.tools

enum class Feature(val category: FeatureCategory){
	CustomTheme(FeatureCategory.UI),
	Material3Theme(FeatureCategory.UI),
	;
	companion object{
		fun getFeaturesFromCategory(category: FeatureCategory):List<Feature>{
			return entries.filter { it.category == category }
		}
	}
}

enum class FeatureCategory{
	UI, Camera
}