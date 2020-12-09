//引用插件编写
plugins{
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")

}
android {
    compileSdkVersion (AppConfig.compileSdkVersion)
    buildToolsVersion (AppConfig.buildToolsVersion)
    defaultConfig {
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode=AppConfig.versionCode
        versionName=AppConfig.versionName

        consumerProguardFiles ("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (DependenciesConfig.STD_LIB)
    implementation (DependenciesConfig.APP_COMPAT)
    implementation (DependenciesConfig.KTX_CORE)
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
    annotationProcessor(DependenciesConfig.APP_COMPAT)
}