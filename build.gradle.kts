plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.compose")
}

android {
    namespace = "com.example.sapnoticeboard"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sapnoticeboard"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
        viewBinding = true  // Enabling ViewBinding
    }
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }  // Include JitPack to resolve dependencies
}

dependencies {
    implementation(libs.androidx.core.ktx.v190)
    implementation(libs.androidx.appcompat.v170)
    implementation(libs.androidx.lifecycle.runtime.ktx.v261)
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")

    // Compose libraries
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))
    implementation("androidx.compose.ui:ui:1.7.6")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.6")

    // Add android-pdf-viewer dependency from JitPack
    implementation("com.github.barteksc:android-pdf-viewer:3.1.0")  // Stable version

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.6")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.7.6")
}
