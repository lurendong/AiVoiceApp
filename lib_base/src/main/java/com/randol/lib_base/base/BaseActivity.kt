package com.randol.lib_base.base

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    abstract fun getLayoutId() : Int

    abstract fun getTitleText():String

    abstract fun isShowBack():Boolean;

    abstract fun initView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP )) {
            supportActionBar?.let {
                title = getTitleText()
                it.elevation = 0f
                it.setDisplayHomeAsUpEnabled(isShowBack())
            }
        }

        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }
}