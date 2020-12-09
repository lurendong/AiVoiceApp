package com.randol.lib_base.helper

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.randol.lib_base.BuildConfig

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.helper
 *  文件名 ：ARouterHelper
 *  创建者 ：LRD
 *  创建时间 ：2020/12/9 10:47
 *  描述 ：ARouter 的帮助类
 *
 */
object ARouterHelper {
    //Module First Run Path
    const val PATH_APP_MANAGER = "/app_manager/app_manager_activity"
    const val PATH_CONSTELLATION = "/constellation/constellation_activity"
    const val PATH_DEVELOPER = "/developer/developer_activity"
    const val PATH_JOKE = "/joke/joke_activity"
    const val PATH_MAP = "/map/map_activity"
    const val PATH_MAP_NAVI = "/map/navi_activity"
    const val PATH_SETTING = "/setting/setting_activity"
    const val PATH_VOICE_SETTING = "/voice/voice_setting_activity"
    const val PATH_WEATHER = "/weather/weather_activity"


    // ARouter 初始化
    fun initHelper(application: Application){
        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(application); // As early as possible, it is recommended to initialize in the Application
    }

    //跳转页面
    fun startActivity(path: String) {
        ARouter.getInstance().build(path).navigation()
    }

    //跳转页面 带返回
    fun startActivity(activity: Activity, path: String, requestCode: Int) {
        ARouter.getInstance().build(path).navigation(activity, requestCode)
    }

    //跳转页面 String
    fun startActivity(path: String, key: String, value: String) {
        ARouter.getInstance().build(path).withString(key, value).navigation()
    }

    //跳转页面 with String
    fun startActivity(path: String, key: String, value: String, key1: String, value1: String) {
        ARouter.getInstance().build(path)
            .withString(key, value)
            .withString(key1, value1)
            .navigation()
    }

    //跳转页面 with Int
    fun startActivity(path: String, key: String, value: Int) {
        ARouter.getInstance().build(path).withInt(key, value).navigation()
    }

    //跳转页面 with Boolean
    fun startActivity(path: String, key: String, value: Boolean) {
        ARouter.getInstance().build(path).withBoolean(key, value).navigation()
    }

    //跳转页面 with Bundle
    fun startActivity(path: String, key: String, bundle: Bundle) {
        ARouter.getInstance().build(path).withBundle(key, bundle).navigation()
    }

    //跳转页面 with Any(object)
    fun startActivity(path: String, key: String, any: Any) {
        ARouter.getInstance().build(path).withObject(key, any).navigation()
    }
}