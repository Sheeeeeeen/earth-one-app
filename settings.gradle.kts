pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Earth One Super App"
include(":app")
include(":core:network")
include(":core:data")
include(":feature")
include(":feature:user")
include(":core:designsystem")
