package com.aking.wanandroid.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.aking.wanandroid.R
import com.aking.wanandroid.app.base.VDBaseFragment
import com.aking.wanandroid.common.http.adapter.getOrNull
import com.aking.wanandroid.databinding.FragmentSearchBinding
import com.aking.wanandroid.util.AppLog

/**
 * Created by Rick on 2022-08-16  11:40.
 * God bless my code!
 * @Description: 搜索页面
 */
class SearchFragment : VDBaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private val vm by viewModels<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollect()
    }

    private fun initCollect() {
        vm.hotKeyFlow.observe(viewLifecycleOwner) {
            AppLog.d("----------->", "livedata 观察1${it.getOrNull()}")
        }

        vm.dailyFlow.observe(viewLifecycleOwner) {
            AppLog.d("----------->", "livedata 观察2${it.getOrNull()}")
        }
    }

}