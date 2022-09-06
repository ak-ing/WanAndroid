package com.aking.wanandroid.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.switchMap
import com.aking.wanandroid.R
import com.aking.wanandroid.app.App
import com.aking.wanandroid.app.base.VDBaseFragment
import com.aking.wanandroid.common.http.adapter.getOrNull
import com.aking.wanandroid.databinding.FragmentSearchBinding
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.TAG
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.switchMap

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
//        vm.hotKeyLiveData.observe(viewLifecycleOwner) {
//            AppLog.d(TAG, it.hots.toString())
//            vdb.flowlayoutHot.setList(it.hots.map { it.first })
//        }
//
//        vm.dailyLiveData.observe(viewLifecycleOwner) {
//            AppLog.d(TAG, it.toString())
////            PlayerManager.loadSongs(it.dailySongs, 0)
//        }

    }

    private fun initCollect() {
        lifecycleScope.launchWhenResumed {  }

    }

}