plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.trialcertificaation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.trialcertificaation"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val lifecycle_version = "2.8.0"
    val room_version = "2.6.1"
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // Retrofit with Kotlin Coroutines
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    // Retrofit with Scalar Converter
    implementation( "com.squareup.retrofit2:converter-scalars:2.9.0")
    // Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
    // Fragment KTX
    implementation("androidx.fragment:fragment-ktx:1.7.1")
    // Lifecycle and LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Mockito framework
    testImplementation ("org.mockito:mockito-core:1.10.19")
    // OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.3")
    // Robolectric tests.
    testImplementation("com.google.dagger:hilt-android-testing:2.44")
    // testKotlin.
    kaptTest("com.google.dagger:hilt-android-compiler:2.44")
    // test Java.
    testAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.44")
    //instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.44")
    // test Kotlin.
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.44")
    //test Java.
    androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.44")
}