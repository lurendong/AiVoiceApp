package com.randol.lib_base.base

import android.app.Application
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.randol.lib_base.helper.ARouterHelper
import com.randol.lib_base.helper.NotificationHelper
import com.randol.lib_base.service.InitService
import com.randol.lib_base.util.SpUtils

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.base
 *  文件名 ：BaseApp
 *  创建者 ：LRD
 *  创建时间 ：2020/12/9 11:09
 *  描述 ：BaseApplication类
 *
 */
open class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()
        ARouterHelper.initHelper(this)
        NotificationHelper.initHelper(this)
        startService(Intent(this,InitService::class.java))
    }
}