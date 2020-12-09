package com.randol.aivoiceapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.randol.lib_base.event.EventManager
import com.randol.lib_base.event.MessageEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EventManager.register(this)


    }

    override fun onDestroy() {
        super.onDestroy()
        EventManager.unregister(this)
    }

}