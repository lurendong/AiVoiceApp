package com.randol.lib_base.event

import android.content.Context
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.*

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.event
 *  文件名 ：EventManager
 *  创建者 ：LRD
 *  创建时间 ：2020/12/9 8:43
 *  描述 ：eventbus 事件管理者
 *
 */
object EventManager {

    //事件订阅注册
    //@param subscribe type Any like object in kotlin
    fun register(subscribe: Any){
        EventBus.getDefault().register(subscribe);
    }

    //事件订阅注销
    fun unregister(subscribe: Any){
        EventBus.getDefault().unregister(subscribe);
    }

    //发送事件类
    private fun post(event:MessageEvent){
        EventBus.getDefault().post(event)
    }
    //发送事件类型 对发送事件类进行一个封装
    fun post(type:Int){
        post((MessageEvent(type)))
    }
    //对发送事件的再次封装 携带string值
    fun post(type: Int,string: String){
        val event = MessageEvent(type)
        event.stringValue = string
        post(event)
    }
    //对发送事件的再次封装 携带int值
    fun post(type: Int,int: Int){
        val event = MessageEvent(type)
        event.intValue = int
        post(event)
    }
    //对发送事件的再次封装 携带boolean值
    fun post(type: Int,boolean: Boolean){
        val event = MessageEvent(type)
        event.booleanValue = boolean
        post(event)
    }

}