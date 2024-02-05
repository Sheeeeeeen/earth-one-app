// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1" apply false
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
