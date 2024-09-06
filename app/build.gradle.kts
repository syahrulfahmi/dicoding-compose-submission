plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.sf.dcd.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sf.dcd.compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "API_URL_IMAGE_ORIGINAL", "\"https://image.tmdb.org/t/p/original\"")
        buildConfigField("String", "API_URL_IMAGE_W500", "\"https://image.tmdb.org/t/p/w500\"")
        buildConfigField("String", "API_KEY", "\"6d8e89d73bd3d00444c8ab6fc7c9ea30\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
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
    implementation(libs.androidx.constraintlayout.compose)

    // coil
    implementation(libs.coil.compose)

    // lottie
    implementation(libs.lottie.compose)

    // navigation
    implementation(libs.androidx.navigation.compose)

    // aac
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.liveData)

    // coroutine
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)

    // hilt
    implementation(libs.hiltAndroid)
    implementation(libs.androidx.ui.text.google.fonts)
    kapt(libs.hiltCompiler)

    // network
    implementation(libs.retrofit)
    implementation(libs.retrofitGsonConverter)
    implementation(libs.gson)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chuckerRelease)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}