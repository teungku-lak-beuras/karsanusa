/* **********************************************************************************************
 * Things that were changed:
 *
 * 1. Added buildscript -> dependencies -> classpath ->
 *    ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.2")
 *
 * NOTES:
 * Shall we use version catalog instead?
 * Example:
 *   implementation("androidx.core:core-ktx:1.15.0")
 *   BECOMES:
 *   implementation(libs.androidx.core.ktx)
 *
 * ********************************************************************************************** */

buildscript {
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.2")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
