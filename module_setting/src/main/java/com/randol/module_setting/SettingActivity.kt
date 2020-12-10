package com.randol.module_setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.randol.lib_base.base.BaseActivity

class SettingActivity : BaseActivity(){
    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun getTitleText(): String {
       return getString(com.randol.lib_base.R.string.app_title_system_setting)
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView() {

    }

}