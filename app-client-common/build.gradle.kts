plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    jvm()
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                val premoVersion = "1.0.0-alpha.05"
                api("me.dmdev.premo:premo:$premoVersion")
                api("me.dmdev.premo:premo-navigation:$premoVersion")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
            }
        }
    }
}

android {
    compileSdk = rootProject.extra["android_sdk_compile"] as Int
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = rootProject.extra["android_sdk_min"] as Int
        targetSdk = rootProject.extra["android_sdk_target"] as Int
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}