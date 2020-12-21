package com.randol.aivoiceapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.randol.lib_base.adapter.CommonAdapter
import com.randol.lib_base.adapter.CommonViewHolder
import com.randol.lib_base.base.BaseActivity
import com.randol.lib_base.event.EventManager
import com.randol.lib_base.event.MessageEvent
import com.randol.lib_base.helper.ARouterHelper
import com.randol.lib_base.util.L
import com.randol.lib_base.util.SpUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity() {
    private lateinit var mList: ArrayList<String>

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getTitleText(): String {
        return getString(R.string.app_name)
    }

    override fun initView() {

        mList = ArrayList()
        for (i in 1..30){
            mList.add("第${i}个")
        }
        content_recyclerView_MainActivity.layoutManager = LinearLayoutManager(this)

        content_recyclerView_MainActivity.adapter = CommonAdapter(mList,object : CommonAdapter.OnBindDataListener<String>{
            override fun onBindViewHolder(
                model: String,
                viewHolder: CommonViewHolder,
                type: Int,
                position: Int
            ) {
                viewHolder.setText(R.id.text_item,model)
            }
            override fun getLayoutId(type: Int): Int {
                return R.layout.test_item
            }
        })
    }

    override fun isShowBack(): Boolean {
        return false
    }



    override fun onDestroy() {
        super.onDestroy()

    }

}