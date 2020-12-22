package com.randol.lib_base.service

import android.app.IntentService
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.randol.lib_base.helper.NotificationHelper
import com.randol.lib_base.util.L
import com.randol.lib_base.util.SpUtils

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.service
 *  文件名 ：InitService
 *  创建者 ：LRD
 *  创建时间 ：2020/12/22 9:19
 *  描述 ：初始化服务 特殊的服务 常用于初始化 短服务 在后台进行初始化服务
 *
 */
class InitService : IntentService(InitService::class.simpleName){
    override fun onCreate() {
        L.e("InitService start")
        super.onCreate()

    }



    override fun onHandleIntent(intent: Intent?) {
        L.e("InitService running")
        SpUtils.initUtils(this)

    }

    override fun onDestroy() {
        L.e("InitService end")
        super.onDestroy()
    }

}