package com.randol.lib_base.helper

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.helper
 *  文件名 ：NotificationHelper
 *  创建者 ：LRD
 *  创建时间 ：2020/12/22 10:51
 *  描述 ：NotificationHelper 绑定通知Channel 帮助实现前台保活
 *
 */
object NotificationHelper {
    private lateinit var mContext: Context
    private lateinit var nm:NotificationManager
    private const val CHANNEL_ID = "ai_voice_service"
    private const val CHANNEL_NAME = "语音服务"

    private const val CHANNEL_INIT_ID = "ai_init_service"
    private const val CHANNEL_INIT_NAME = "初始化服务"
    fun initHelper(mContext:Context){
        this.mContext = mContext
        nm = mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        setBindVoiceChannel()
    }

    // to set a channel to bind service
    fun setBindVoiceChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel =
                NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            //呼吸灯关闭
            notificationChannel.enableLights(false)
            //震动关闭
            notificationChannel.enableVibration(false)
            //角标关闭
            notificationChannel.setShowBadge(false)
            nm.createNotificationChannel(notificationChannel)
        }
    }
    fun bindVoiceService(contentText:String): Notification {
        val notificationCompat: NotificationCompat.Builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //通知栏对象
            NotificationCompat.Builder(mContext, CHANNEL_ID)
        }else{
            NotificationCompat.Builder(mContext)
        }
        notificationCompat.setContentTitle(CHANNEL_NAME)
        notificationCompat.setContentText(contentText)
        notificationCompat.setWhen(System.currentTimeMillis())
        notificationCompat.setAutoCancel(false)
        return notificationCompat.build()
    }
}