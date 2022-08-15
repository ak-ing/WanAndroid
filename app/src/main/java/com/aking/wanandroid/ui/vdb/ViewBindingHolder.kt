package com.aking.wanandroid.ui.vdb

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * [ViewDataBinding] ViewHolder
 */
open class ViewBindingHolder<VD : ViewDataBinding>(open val binding: VD) :
    RecyclerView.ViewHolder(binding.root)