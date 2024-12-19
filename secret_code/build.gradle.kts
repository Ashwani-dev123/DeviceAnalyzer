plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs")
    id("maven-publish")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")


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
                version = "1.2.8"
            }
        }
    }
}



dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    implementation ("com.intuit.sdp:sdp-android:1.1.0")


    kapt("org.androidannotations:androidannotations:4.8.0")
    implementation("org.androidannotations:androidannotations-api:4.8.0")
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation ("com.airbnb.android:epoxy:5.1.4")
    implementation ("com.airbnb.android:epoxy-databinding:5.1.4")
    implementation ("com.akexorcist:round-corner-progress-bar:2.1.2")
    implementation ("com.github.lzyzsd:circleprogress:1.2.1")
    implementation ("io.insert-koin:koin-android:3.3.2")
    implementation ("com.getkeepsafe.relinker:relinker:1.4.5")
    implementation ("androidx.preference:preference-ktx:1.2.1")
    implementation ("androidx.work:work-runtime-ktx:2.9.1")
    kapt ("com.airbnb.android:epoxy-processor:5.1.4")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.5")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.5")
    implementation ("com.google.android.ump:user-messaging-platform:3.0.0")
    implementation ("androidx.multidex:multidex:2.0.1")
    implementation ("com.chibatching.kotpref:kotpref:2.13.1")
    implementation ("com.chibatching.kotpref:gson-support:2.13.1")
    implementation ("com.google.android.gms:play-services-location:21.3.0")
    implementation ("com.github.ome450901:SimpleRatingBar:1.5.1")
    implementation ("com.google.android.play:review-ktx:2.0.1")
    implementation ("org.apache.commons:commons-math3:3.6.1")
    implementation ("com.github.wendykierp:JTransforms:3.1")
    implementation ("com.github.Ashwani-dev123:NarayanAds:1.2.4")
    
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")

    //app locale
    implementation("dev.b3nedikt.applocale:app-locale:2.0.2")
    //spinkit
    implementation ("com.github.ybq:Android-SpinKit:1.4.0")
}