package com.aking.wanandroid.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aking.wanandroid.app.App
import com.aking.wanandroid.common.http.adapter.getOrElse
import com.aking.wanandroid.common.services.bean.HotKeyBean
import com.aking.wanandroid.common.services.bean.RecommendSongData
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.TAG

/**
 * Created by Rick on 2022-08-16  15:54.
 * God bless my code!
 * @Description:
 */
class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    val hotKeyLiveData: LiveData<HotKeyBean> = liveData {
        AppLog.d(TAG, "------>hotKeyLiveData")
        emit(repository.getHotKeyList().getOrElse { HotKeyBean(emptyList()) })
    }

    val dailyLiveData: LiveData<RecommendSongData> = liveData {
        AppLog.d(TAG, "------>dailyLiveData ")
        emit(repository.getDailyRecommendSongs(App.instance().getCookie(repository.getService()))
            .getOrElse { RecommendSongData(emptyList(), emptyList()) })
    }

}