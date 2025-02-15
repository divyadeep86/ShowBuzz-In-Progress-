// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
    id("com.google.dagger.hilt.android") version "2.51" apply false
    alias(libs.plugins.compose.compiler) apply false
    kotlin("jvm") version "1.6.10"
}
