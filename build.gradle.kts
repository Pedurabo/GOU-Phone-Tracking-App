plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "ug.gov.clearance"
    compileSdk = rootProject.ext["compileSdk"] as Int

    defaultConfig {
        applicationId = "ug.gov.clearance"
        minSdk = rootProject.ext["minSdk"] as Int
        targetSdk = rootProject.ext["targetSdk"] as Int
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        // Required for 16 KB page size (Android 15+ / Google Play Nov 2025): native libs
        // must be stored uncompressed and page-aligned; do not use legacy .so compression.
        jniLibs.useLegacyPackaging = false
        // play-services-mlkit-text-recognition AAR ships libimage_processing_util_jni.so with
        // 4 KB LOAD alignment; exclude it so the APK passes the 16 KB check. On devices with
        // Play Services, the implementation is provided at runtime. Test the scan flow on a
        // 16 KB device/emulator after building.
        jniLibs.excludes.add("**/libimage_processing_util_jni.so")
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":core-common"))
    implementation(project(":core-security"))
    implementation(project(":core-sync"))
    implementation(project(":feature-scan"))
    implementation(project(":feature-clearance"))
    implementation(project(":feature-ownership"))
    implementation(project(":feature-auth"))

    val composeBom = platform("androidx.compose:compose-bom:2024.03.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    implementation("com.google.dagger:hilt-android:2.57")
    kapt("com.google.dagger:hilt-compiler:2.57")
    implementation("androidx.hilt:hilt-work:1.1.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    implementation("androidx.work:work-runtime-ktx:2.9.0")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}
