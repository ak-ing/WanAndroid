package com.aking.wanandroid.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by AK on 2022/8/15 22:53.
 * God bless my code!
 * @Description: DataBinding基类Fragment
 */
abstract class VDBaseFragment<VB : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    BaseFragment() {

    private var _vdb: VB? = null
    protected val vdb: VB get() = _vdb!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<VB>(inflater, layoutResId, container, false)
        .also {
            it.lifecycleOwner = viewLifecycleOwner
            _vdb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _vdb = null
    }
}