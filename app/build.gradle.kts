import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    id("com.google.gms.google-services")
    alias(libs.plugins.secrets)
}

android {
    namespace = "com.example.taskmanger"

    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.taskmanger"
        minSdk = 26
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    // =========================
    // Core
    // =========================

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.activity.compose)


    // =========================
    // DataStore
    // =========================

    implementation(libs.androidx.datastore.preferences)


    // =========================
    // Compose
    // =========================

    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.runtime.livedata)


    // =========================
    // Navigation
    // =========================

    implementation(libs.androidx.navigation.compose)


    // =========================
    // Lifecycle
    // =========================

    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)


    // =========================
    // Ktor
    // =========================

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)


    // =========================
    // Room
    // =========================

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    ksp(libs.androidx.room.compiler)


    // =========================
    // Hilt
    // =========================

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)

    ksp(libs.hilt.compiler)


    // =========================
    // Coil
    // =========================

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)


    // =========================
    // Google Maps
    // =========================

    implementation(libs.play.services.location)
    implementation(libs.play.services.maps)
    implementation(libs.maps.compose)
    implementation(libs.maps.utils)


    // =========================
    // Retrofit
    // =========================

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)


    // =========================
    // Glide
    // =========================

    implementation(libs.glide)
    implementation(libs.glide.compose)


    // =========================
    // Shimmer
    // =========================

    implementation(libs.kmp.shimmer.compose)


    // =========================
    // Permissions
    // =========================

    implementation(libs.accompanist.permissions)


    // =========================
    // Unit Tests
    // =========================

    testImplementation(libs.junit)


    // =========================
    // Android Tests
    // =========================

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)


    // =========================
    // Debug
    // =========================

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    //==============================
    //  Fire base
    // =============================
    implementation(platform("com.google.firebase:firebase-bom:34.18.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("androidx.core:core-splashscreen:1.0.0")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:34.18.0"))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth")

}
