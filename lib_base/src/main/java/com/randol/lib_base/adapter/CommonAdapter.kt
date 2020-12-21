package com.randol.lib_base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


/**
 *  项目名 ：AiVoiceApp
 *  包名 ： com.randol.lib_base.adapter
 *  文件名 ：CommonAdapter
 *  创建者 ：LRD
 *  创建时间 ：2020/12/11 10:07
 *  描述 ：adapter 万能适配器
 *
 */
open class CommonAdapter<T> : RecyclerView.Adapter<CommonViewHolder> {

    //数据
    private var mList: List<T>

    //接口
    private var onBindDataListener: OnBindDataListener<T>? = null
    private var onMoreBindDataListener: OnMoreBindDataListener<T>? = null

    constructor(mList: List<T>, onBindDataListener: OnBindDataListener<T>) {
        this.mList = mList
        this.onBindDataListener = onBindDataListener
    }

    constructor(mList: List<T>, onMoreBindDataListener: OnMoreBindDataListener<T>) {
        this.mList = mList
        this.onBindDataListener = onMoreBindDataListener
        this.onMoreBindDataListener = onMoreBindDataListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        val layoutId = onBindDataListener?.getLayoutId(viewType)
        return CommonViewHolder.getViewHolder(parent, layoutId!!)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        onBindDataListener?.onBindViewHolder(
            mList[position],
            holder,
            getItemViewType(position),
            position
        )
    }

    override fun getItemViewType(position: Int): Int {
        if (onMoreBindDataListener != null) {
            return onMoreBindDataListener!!.getItemType(position)
        }
        return 0
    }

    interface OnBindDataListener<T> {
        fun onBindViewHolder(model: T, viewHolder: CommonViewHolder, type: Int, position: Int)
        fun getLayoutId(type: Int): Int
    }

    interface OnMoreBindDataListener<T> : OnBindDataListener<T> {
        fun getItemType(position: Int): Int
    }

}