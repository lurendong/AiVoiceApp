package com.randol.module_developer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.randol.lib_base.adapter.CommonAdapter
import com.randol.lib_base.adapter.CommonViewHolder
import com.randol.lib_base.base.BaseActivity
import com.randol.lib_base.helper.ARouterHelper
import com.randol.lib_base.util.L
import com.randol.module_developer.data.DevelopListData
import kotlinx.android.synthetic.main.activity_developer.*

@Route(path = ARouterHelper.PATH_DEVELOPER)
class DeveloperActivity : BaseActivity() {
    private val mTypeTitle = 0
    private val mTypeContent = 1
    private val mList = ArrayList<DevelopListData>()

    override fun getLayoutId(): Int {
        return R.layout.activity_developer
    }

    override fun getTitleText(): String {
        return getString(com.randol.lib_base.R.string.app_title_developer)
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView() {
        initData()
        initListView()
    }

    private fun initListView() {
        rv_develop_content.layoutManager =LinearLayoutManager(this)
        rv_develop_content.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        rv_develop_content.adapter = CommonAdapter(mList,object :CommonAdapter.OnMoreBindDataListener<DevelopListData>{
            override fun onBindViewHolder(
                model: DevelopListData,
                viewHolder: CommonViewHolder,
                type: Int,
                position: Int
            ) {
                when(model.type){
                    mTypeTitle->{
                        viewHolder.setText(R.id.tv_developer_title,model.text)
                    }
                    mTypeContent->{
                        viewHolder.setText(R.id.tv_developer_content,"${position}.${model.text}")
                        viewHolder.itemView.setOnClickListener{
                            itemClick(position)
                        }
                    }

                }
            }

            override fun getLayoutId(type: Int): Int {
                return if (type == mTypeTitle){
                    R.layout.layout_developer_title
                }else{
                    R.layout.layout_developer_content
                }
            }

            override fun getItemType(position: Int): Int {
                return mList[position].type
            }
        })
    }

    private fun initData() {
        val dataArray = resources.getStringArray(R.array.DeveloperListArray)
        dataArray.forEach {
            if (it.contains("[")) {
                addItemData(mTypeTitle,it.replace("[","").replace("]",""))
            }else{
                addItemData(mTypeContent,it)
            }
        }
    }
    private fun addItemData(type:Int,text:String){
            val data = DevelopListData(type,text)
            mList.add(data)
    }
    private fun itemClick(position:Int){
        when(position){
            1->{
                ARouterHelper.startActivity(ARouterHelper.PATH_APP_MANAGER)
            }
            2->{
                ARouterHelper.startActivity(ARouterHelper.PATH_CONSTELLATION)
            }
            3->{
                ARouterHelper.startActivity(ARouterHelper.PATH_JOKE)
            }
            4->{
                ARouterHelper.startActivity(ARouterHelper.PATH_MAP)
            }
            5->{
                L.e("ARouter start")

                ARouterHelper.startActivity(ARouterHelper.PATH_SETTING)
                L.e("ARouter end")
            }
            6->{
                ARouterHelper.startActivity(ARouterHelper.PATH_VOICE_SETTING)
            }
            7->{
                ARouterHelper.startActivity(ARouterHelper.PATH_WEATHER)
            }
        }
    }

}