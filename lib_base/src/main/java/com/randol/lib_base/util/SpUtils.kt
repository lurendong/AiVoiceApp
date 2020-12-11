package com.randol.lib_base.util

import android.content.Context
import android.content.SharedPreferences

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.util
 *  文件名 ：SpUtils
 *  创建者 ：LRD
 *  创建时间 ：2020/12/11 8:32
 *  描述 ：对 SharedPreferences 进行封装
 *
 */
object SpUtils {
    private const val SP_NAME = "config"

    //对象
    private lateinit var sp: SharedPreferences
    private lateinit var spEditor: SharedPreferences.Editor

    //初始化
    fun initUtils(mContext: Context) {
        sp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        spEditor = sp.edit()
        spEditor.apply()
    }

    fun putString(key: String, value: String) {
        spEditor.putString(key, value)
        spEditor.commit()
    }

    fun getString(key: String): String? {
        return sp.getString(key, "")
    }

    fun putInt(key: String, value: Int) {
        spEditor.putInt(key, value)
        spEditor.commit()
    }

    fun getInt(key: String, defValue: Int): Int {
        return sp.getInt(key, defValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        spEditor.putBoolean(key, value)
        spEditor.commit()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sp.getBoolean(key, defValue)
    }
}