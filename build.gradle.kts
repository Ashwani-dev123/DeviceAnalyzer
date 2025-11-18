// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{
        classpath("com.google.gms:google-services:4.4.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")

    }
}
plugins {
    id("com.android.application") version "8.7.0" apply false
    id ("com.android.library") version "8.7.0" apply false
    id("org.jetbrains.kotlin.android") version "2.2.10" apply false
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.26" apply false
}