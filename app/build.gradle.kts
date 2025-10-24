import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.compose)
	alias(libs.plugins.hilt)
	alias(libs.plugins.kotlinPluginSerialization)
	alias(libs.plugins.ksp)
	//alias(libs.plugins.google.services)
}

android {
	namespace = "com.kognitivist.devfeaturehubandroid"
	compileSdk {
		version = release(36)
	}

	defaultConfig {
		applicationId = "com.kognitivist.devfeaturehubandroid"
		minSdk = 28
		targetSdk = 36
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}

	kotlin {
		jvmToolchain(17)
	}

	tasks.withType<KotlinJvmCompile>().configureEach {
		compilerOptions {
			jvmDefault.set(JvmDefaultMode.ENABLE)
			freeCompilerArgs.add("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
		}
	}

	buildFeatures {
		compose = true
	}
}

dependencies {
	//region Basic
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.fragment.ktx)
	implementation(libs.androidx.compose.runtime.livedata)
	implementation(libs.androidx.lifecycle.viewmodel.compose)
	implementation(libs.androidx.lifecycle.livedata.ktx)
	implementation(libs.androidx.lifecycle.process)
	//endregion
	//region UI
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.fonts)
	implementation(libs.androidx.compose.ui.tooling.preview)
	implementation(libs.androidx.material3)
	implementation(libs.androidx.navigation.compose)
	implementation(libs.coil.compose)
	implementation(libs.coil)
	implementation(libs.lottie.compose)
	implementation(libs.androidx.adaptive)
	implementation(libs.androidx.material.navigation)
	implementation(libs.material)
	implementation(libs.material.icons.extended)
	//endregion
	//region Network
	implementation(libs.retrofit)
	implementation(libs.okhttp)
	//endregion
	//region Data
	implementation(libs.androidx.room.runtime)
	ksp(libs.androidx.room.compiler)
	implementation(libs.androidx.room.ktx)
	implementation(libs.androidx.datastore.preferences)
	//endregion
	//region Logging
	implementation(libs.logging.interceptor)
	debugImplementation(libs.chucker)
	releaseImplementation(libs.chucker.no.op)
	//endregion
	//region DI
	implementation(libs.hilt.android)
	implementation(libs.androidx.hilt.navigation.compose)
	ksp(libs.hilt.android.compiler)
	//endregion
	//region Tools
	implementation(libs.androidx.credentials)
	implementation(libs.androidx.credentials.play.services.auth)
	implementation(libs.libphonenumber)
	implementation(libs.androidx.work)
	implementation(libs.analytics)
	implementation(platform(libs.firebase.bom))
	implementation(libs.firebase.analytics)
	implementation(libs.kotlinx.serialization.json)
	implementation(libs.converter.gson)
	implementation(libs.gson)
	implementation(libs.lyricist)
	ksp(libs.lyricist.processor)
	implementation(libs.flocon)
	implementation(libs.app.update)
	implementation(libs.app.update.ktx)
	//endregion
	//region Tests
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
	//endregion

	//implementation(libs.mobileads)
	implementation(libs.androidx.core.splashscreen)
	implementation(project(":custom_theme"))
	implementation(project(":material3_theme"))
}