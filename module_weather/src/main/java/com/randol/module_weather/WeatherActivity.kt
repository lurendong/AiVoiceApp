package com.randol.module_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.randol.lib_base.base.BaseActivity
import com.randol.lib_base.helper.ARouterHelper

@Route(path = ARouterHelper.PATH_WEATHER)
class WeatherActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_weather

    }

    override fun getTitleText(): String {
        return getString(com.randol.lib_base.R.string.app_title_weather)
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView() {
    }

}