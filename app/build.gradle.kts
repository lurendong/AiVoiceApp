import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCallArgument.DefaultArgument.arguments

//引用插件编写
plugins{
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}
android {
    compileSdkVersion (AppConfig.compileSdkVersion)
    buildToolsVersion (AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId=AppConfig.applicationId
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode=AppConfig.versionCode
        versionName=AppConfig.versionName

        testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner"
        //ARouter
        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
            }
        }
    }

    signingConfigs{
        register("release"){

            keyAlias = "randol"
            keyPassword = "LRDaivoice"
            //签名路径
            storeFile = file("G:\\work_space\\key\\aivoice.jks")
            //签名密码
            storePassword ="LRDaivoice"
        }
    }

    buildTypes {
        getByName("debug") {

        }
        getByName("release") {
            isMinifyEnabled  = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    android.applicationVariants.all{
        val buildType = this.buildType.name
        outputs.all {
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl){
                if(buildType == "release"){
                    this.outputFileName = "AI_V${defaultConfig.versionName}_$buildType.apk"
                }

            }
        }
    }
    //依赖操作
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":lib_base"))
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
    if (!ModuleConfig.isApp) {
        implementation(project(":module_app_manager"))
        implementation(project(":module_constellation"))
        implementation(project(":module_developer"))
        implementation(project(":module_joke"))
        implementation(project(":module_map"))
        implementation(project(":module_setting"))
        implementation(project(":module_voice_setting"))
        implementation(project(":module_weather"))
    }
    //运行时注解
    kapt(DependenciesConfig.AROUTER_COMPILER)
}