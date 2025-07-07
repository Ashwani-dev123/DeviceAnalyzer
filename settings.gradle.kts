pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()

        maven {
            url = uri("https://maven.google.com/")
            name = "Google"
        }

        maven {
            url = uri("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }
        maven {
            url = uri("https://artifact.bytedance.com/repository/pangle")
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven {
            url = uri("https://maven.google.com/")
            name = "Google"
        }
        maven {
            url = uri("https://jitpack.io")
        }

        maven {
            url = uri("https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
        }
        maven {
            url = uri("https://artifact.bytedance.com/repository/pangle")
        }
    }
}
rootProject.name = "DeviceAnalyzer"
include(":secret_code")
 