package com.randol.lib_base.event

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.event
 *  文件名 ：MessageEvent
 *  创建者 ：LRD
 *  创建时间 ：2020/12/9 8:41
 *  描述 ：eventbus 消息事件对象
 *
 */
class MessageEvent(val type:Int) {
    var stringValue:String = ""
    var intValue:Int = 0;
    var booleanValue:Boolean = false;
}