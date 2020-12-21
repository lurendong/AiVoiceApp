/**
 * FileName: KotlinConstants
 * Founder: LiuGuiLin
 * Profile: Kotlin 常量
 */

//全局常量


object KotlinConstants {

    //Gradle 版本
    const val gradle_version = "4.0.1"

    //Kotlin 版本
    const val kotlin_version = "1.3.72"
}
object AppConfig{

    const val compileSdkVersion = 29
    const val buildToolsVersion = "30.0.2"
    const val applicationId = "com.randol.aivoiceapp"
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionCode = 1
    const val versionName = "1.0"
}

object DependenciesConfig{
    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${KotlinConstants.kotlin_version}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val KTX_CORE = "androidx.core:core-ktx:1.3.2"
    //EventBus
    const val EVENT_BUS = "org.greenrobot:eventbus:3.2.0"

    //ARouter
    const val AROUTER = "com.alibaba:arouter-api:1.5.0"
    const val AROUTER_COMPILER = "com.alibaba:arouter-compiler:1.2.2"

    //RecyclerView
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.2.0-alpha01"

    //Permissions
    const val AND_PERMISSIONS = "com.yanzhenjie:permission:2.0.3"

    //Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.8.1"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:2.8.1"

    //ViewPager
    const val VIEWPAGER = "com.zhy:magic-viewpager:1.0.1"
    const val MATERIAL = "com.google.android.material:material:1.0.0"

    //Lottie
    const val LOTTIE = "com.airbnb.android:lottie:3.4.0"

    //刷新
    const val REFRESH_KERNEL = "com.scwang.smart:refresh-layout-kernel:2.0.1"
    const val REFRESH_HEADER = "com.scwang.smart:refresh-header-classics:2.0.1"
    const val REFRESH_FOOT = "com.scwang.smart:refresh-footer-classics:2.0.1"

    //图表
    const val CHART = "com.github.PhilJay:MPAndroidChart:v3.1.0"

}
object ModuleConfig {

    //Module是否App
    var isApp = true
    //包名
    const val MODULE_APP_MANAGER = "com.randol.module_app_manager"
    const val MODULE_CONSTELLATION = "com.randol.module_constellation"
    const val MODULE_DEVELOPER = "com.randol.module_developer"
    const val MODULE_JOKE = "com.randol.module_joke"
    const val MODULE_MAP = "com.randol.module_map"
    const val MODULE_SETTING = "com.randol.module_setting"
    const val MODULE_VOICE_SETTING = "com.randol.module_voice_setting"
    const val MODULE_WEATHER = "com.randol.module_weather"
}
