plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs")
    id("maven-publish")
    id("com.google.gms.google-services")


}

android {
    namespace = "com.example.githhubdemo"
    compileSdk = 34

    defaultConfig {
//        applicationId = "com.example.githhubdemo"
        minSdk = 24
        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                arguments += "-DANDROID_STL=c++_static"
            }
        }

        /*manifestPlaceholders["ad_app_id"] =  "ca-app-pub-3940256099942544~3347511713"
        buildConfigField("String", "ad_interstitial_splash", "\"ca-app-pub-oifjsdjg895yeu5jgoijn90rsdghe5\"")
        buildConfigField("String", "ad_banner", "\"ca-app-pub-oifjsdjg895yeu5jgoijn90rsdghe5\"")
        buildConfigField("Boolean", "env_dev", "true")*/

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


    externalNativeBuild {
        cmake {
//            path("src/main/cpp/CMakeLists.txt")
            path("../secret_code/src/main/cpp/CMakeLists.txt")

        }
    }
    kapt {
        correctErrorTypes = true
        useBuildCache = true
    }
    splits {
        abi {
            isEnable
            reset()
            include ("armeabi-v7a', 'arm64-v8a', 'x86', 'x86_64")
            isUniversalApk

        }
    }
    packaging {
        exclude ("META-INF/DEPENDENCIES")
    }

    lint {
        baseline = file("lint-baseline.xml")
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true

        aidl = true
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from (components["release"])
                groupId = "com.github.Ashwani-dev123"
                artifactId = "secret_code"
                version = "1.2.0"
            }
        }
    }
}



dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation ("com.intuit.sdp:sdp-android:1.1.0")


    annotationProcessor ("org.androidannotations:androidannotations:4.8.0")
    implementation ("org.androidannotations:androidannotations-api:4.8.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.2")

    implementation ("com.airbnb.android:epoxy:5.1.3")
    implementation ("com.airbnb.android:epoxy-databinding:5.1.3")
    implementation ("com.akexorcist:round-corner-progress-bar:2.1.2")
    implementation ("com.github.lzyzsd:circleprogress:1.2.1")
    implementation ("io.insert-koin:koin-android:3.3.2")
    implementation ("com.getkeepsafe.relinker:relinker:1.4.5")
    implementation ("androidx.preference:preference-ktx:1.2.0")
    implementation ("androidx.work:work-runtime-ktx:2.8.1")
    kapt ("com.airbnb.android:epoxy-processor:5.1.3")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("com.google.android.ump:user-messaging-platform:2.2.0")
    implementation ("androidx.multidex:multidex:2.0.1")
    implementation ("com.chibatching.kotpref:kotpref:2.13.1")
    implementation ("com.chibatching.kotpref:gson-support:2.10.0")
    implementation ("com.google.android.gms:play-services-location:21.2.0")
    implementation ("com.github.ome450901:SimpleRatingBar:1.5.1")
    implementation ("com.google.android.play:review-ktx:2.0.1")
    implementation ("org.apache.commons:commons-math3:3.6.1")
    implementation ("com.github.wendykierp:JTransforms:3.1")
    implementation ("com.github.Ashwani-dev123:NarayanAds:1.1.2")


}