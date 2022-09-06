package com.aking.wanandroid.ui.search

import androidx.lifecycle.ViewModel
import com.aking.wanandroid.util.AppLog
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Created by Rick on 2022-08-16  15:54.
 * God bless my code!
 * @Description:
 */
class SearchViewModel : ViewModel() {

    private val repository = SearchRepository()

    val hotKeyLiveData = flow { emit(repository.getHotKeyList()) }.catch {
        AppLog.e(msg = it.message.toString())
    }

    val dailyLiveData = flow { emit(repository.getDailyRecommendSongs()) }.catch {
        AppLog.e(msg = it.message.toString())
    }

}