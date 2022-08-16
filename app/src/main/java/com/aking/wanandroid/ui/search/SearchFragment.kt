package com.aking.wanandroid.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.aking.wanandroid.R
import com.aking.wanandroid.app.base.VDBaseFragment
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.TAG

/**
 * Created by Rick on 2022-08-16  11:40.
 * God bless my code!
 * @Description: 搜索页面
 */
class SearchFragment : VDBaseFragment(R.layout.fragment_search) {

    private val vm by viewModels<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.hotKeyLiveData.observe(viewLifecycleOwner) {
            AppLog.d(TAG, it.hots.toString())
        }
    }

}