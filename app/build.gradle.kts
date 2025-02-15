import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlinx-serialization")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.vh.showbuzz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vh.showbuzz"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localProperties.load(FileInputStream(localPropertiesFile))
        }
        buildConfigField("String", "AUTH_TOKEN", "\"${localProperties.getProperty("authToken")}\"")
    }
buildFeatures{
    buildConfig = true
}
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material3.adaptive)
    implementation(libs.androidx.material3.adaptive.navigation.suite)
/*    implementation(libs.androidx.adaptive)
    implementation(libs.androidx.adaptive.layout)
    implementation(libs.androidx.adaptive.navigation)
    implementation(libs.androidx.material3.android)*/
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation (libs.androidx.paging.compose)
    implementation (libs.androidx.lifecycle.viewmodel.compose)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.savedstate)
    implementation (libs.androidx.navigation.compose)
    implementation (libs.androidx.lifecycle.runtime.compose)

    //Coil
    implementation (libs.coil.compose)

    //DaggerHilt
    implementation (libs.androidx.hilt.navigation.compose)
    implementation (libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)

    //Network
    implementation (libs.okhttp)
    implementation (libs.loggingInterceptor)
    implementation(libs.kotlinx.serialization.json)
    implementation (libs.retrofit)
    implementation (libs.retrofit2.kotlinx.serialization.converter)
}