plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
}

android {
    namespace = "com.atlys.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.atlys.movieapp"
        minSdk = 24
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

            buildConfigField("String", "API_KEY",  "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNWY0NjM0MDMxMDAyYzIwMWFiNTFiMTE2NWQyZGYyZSIsIm5iZiI6MTcyMzM3MzcyMC45NTg5NzgsInN1YiI6IjY2Yjg4OTc4ZDE2YjdhNzM2M2YyYzIwMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pzZBi30LhCHzoLcnCpqBq2yzlAunABzVKlZ-idEiRKI\"")
        }
        debug {
            buildConfigField("String", "API_KEY",  "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNWY0NjM0MDMxMDAyYzIwMWFiNTFiMTE2NWQyZGYyZSIsIm5iZiI6MTcyMzM3MzcyMC45NTg5NzgsInN1YiI6IjY2Yjg4OTc4ZDE2YjdhNzM2M2YyYzIwMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.pzZBi30LhCHzoLcnCpqBq2yzlAunABzVKlZ-idEiRKI\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures{
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.lifecycleRuntime)

    //compose
    implementation(libs.composeUi)
    implementation(libs.composeMaterial)
    implementation(libs.composeMaterialExtended)
    implementation(libs.composePreview)
    implementation(libs.activityCompose)

    implementation(libs.pagerCompose)
    implementation(libs.pagerIndicator)
    implementation(libs.navigationCompose)

    implementation(libs.destinationCompose)
    ksp(libs.destinationComposeKsp)

    // image loading
    implementation(libs.coilCompose)

    // di
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltNavigationCompose)

    // Coroutines
    implementation(libs.coroutines)
    implementation(libs.coroutineCore)

    implementation(libs.retrofit)
    implementation(libs.retrofitConverter)


}