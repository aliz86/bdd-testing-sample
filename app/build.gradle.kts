plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.bddtestingwithcucumbergherkinespressoselenium"
    compileSdk = 34

    sourceSets {
        getByName("androidTest") {
            assets.srcDirs(files("$projectDir/src/androidTest/resources"))
        }
    }

    defaultConfig {
        applicationId = "com.example.bddtestingwithcucumbergherkinespressoselenium"
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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")


    testImplementation ("androidx.test:rules:1.6.1")
    androidTestImplementation ("com.android.support.test:runner:1.0.2")


    androidTestImplementation ("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.6.1") // For additional Espresso utilities

    androidTestImplementation ("androidx.test.ext:junit:1.2.1")

    androidTestImplementation ("io.cucumber:cucumber-android:7.14.0")
    /* apparently no need to:
    androidTestImplementation ("io.cucumber:cucumber-junit:7.14.0")
    androidTestImplementation ("io.cucumber:cucumber-gherkin:7.14.0")
    androidTestImplementation ("io.cucumber:cucumber-java:7.14.0")*/
}