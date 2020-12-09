package com.randol.module_app_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.randol.lib_base.base.BaseActivity

class AppManagerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_manager)
    }
}