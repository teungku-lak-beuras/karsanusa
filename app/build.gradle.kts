/* **********************************************************************************************
 * Things that were changed:
 *
 * 1. compileOptions
 *    sourceCompatibility VERSION_11 to VERSION_17
 *    targetCompatibility VERSION_11 to VERSION_17
 *
 * 2. kotlinOptions
 *    jvmTarget "11" to "17" (Must have the same JVM version for sourceCompatibility and
 *                            targetCompatibility)
 *
 * 3. viewBinding false to true
 *
 * 4. Dependencies that were added:
 *      implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
 *      implementation("androidx.navigation:navigation-ui-ktx:2.7.2")
 *
 * 5. Plugins that were added:
 *      id("androidx.navigation.safeargs")
 *
 * 6. android -> compileSdk 34 to 35 (Android 15)
 * 7. android -> defaultConfig -> targetSdk 34 to 35 (Android 15)
 *
 * REASONING:
 *
 * 1. Why use JVM 17? Because Android ROOM need that. We would probably use ROOM.
 * 2. Why use SDK 35? Because my Android Studio is the latest version and it it keeps crying for it.
 *
 * NOTES:
 *
 * 1. Adding new plugins shall be at the bottom of
 *      alias(libs.plugins.android.application)
 *      alias(libs.plugins.kotlin.android)
 *      < PUT YOUR PLUGINS HERE >
 *    Not doing so will cause org.gradle.api.plugins.InvalidPluginException
 *
 * QUESTIONS:
 *
 * 1. Shall we use version catalog instead?
 *      Example:
 *        implementation("androidx.core:core-ktx:1.15.0")
 *      BECOMES:
 *        implementation(libs.androidx.core.ktx)
 *
 * ********************************************************************************************** */

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.capstone.karsanusa"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.capstone.karsanusa"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
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
}

dependencies {
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
