// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        //navigation
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
        //hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}