package com.aking.wanandroid.ui.search

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.aking.wanandroid.app.base.BaseViewModel
import com.aking.wanandroid.common.http.adapter.NetworkResponse
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

/**
 * Created by Rick on 2022-08-16  15:54.
 * God bless my code!
 * @Description:
 */
class SearchViewModel : BaseViewModel() {

    private val repository = SearchRepository()

    val hotKeyFlow = liveData {
        repository.getHotKeyList()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), NetworkResponse.Loading())
            .collect(this::emit)
    }

    val dailyFlow = repository.getDailyRecommendSongs()

}