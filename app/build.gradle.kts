plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "com.gshockv.cwapp"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.gshockv.cwapp"
    minSdk = 33
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation(libs.bundles.andsroidX)
  implementation(platform(libs.compose.bom))
  debugImplementation(libs.compose.ui.tooling)
  implementation(libs.bundles.ui)
}
