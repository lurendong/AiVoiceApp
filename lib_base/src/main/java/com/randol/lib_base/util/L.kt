package com.randol.lib_base.util

import android.util.Log
import com.randol.lib_base.BuildConfig

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.util
 *  文件名 ：L
 *  创建者 ：LRD
 *  创建时间 ：2020/12/10 17:46
 *  描述 ：对log封装
 *
 */
object L {
    private const val TAG ="AIVoiceApp"
    fun i(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.i(TAG, it)
            }
        }
    }

    fun e(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.e(TAG, it)
            }
        }
    }
}