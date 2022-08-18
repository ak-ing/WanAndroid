package com.aking.wanandroid.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.aking.wanandroid.common.http.adapter.getOrElse
import com.aking.wanandroid.common.services.bean.HotKeyBean
import com.aking.wanandroid.common.services.bean.RecommendSongData
import kotlinx.coroutines.launch

/**
 * Created by Rick on 2022-08-16  15:54.
 * God bless my code!
 * @Description:
 */
class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    val hotKeyLiveData: LiveData<HotKeyBean> = liveData {
        emit(repository.getHotKeyList().getOrElse { HotKeyBean(emptyList()) })
    }

    val dailyLiveData:LiveData<RecommendSongData> = liveData {
        val anonymous = repository.service2.registerByAnonymous()
        emit(repository.service2.getDailyRecommendSongs(anonymous.getOrElse { "aaaaaa-----" }).getOrElse { RecommendSongData(emptyList(), emptyList()) })
    }

}