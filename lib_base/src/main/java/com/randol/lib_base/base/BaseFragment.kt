package com.randol.lib_base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.base
 *  文件名 ：BaseFragment
 *  创建者 ：LRD
 *  创建时间 ：2020/12/9 17:11
 *  描述 ：对Fragment的封装 使fragment 更好使用
 *
 */
abstract class BaseFragment : Fragment(){
    abstract fun getLayoutId() : Int

    abstract fun initView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

}