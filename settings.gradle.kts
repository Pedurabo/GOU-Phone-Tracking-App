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

rootProject.name = "gou-phone-tracking"
include(
    ":app",
    ":domain",
    ":data",
    ":core-common",
    ":core-security",
    ":core-sync",
    ":feature-scan",
    ":feature-clearance",
    ":feature-ownership",
    ":feature-auth"
)
