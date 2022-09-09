package com.aking.wanandroid.ui.search

import androidx.lifecycle.asLiveData
import com.aking.wanandroid.app.base.BaseRepository
import com.aking.wanandroid.common.http.RetrofitManager
import com.aking.wanandroid.common.services.SearchService
import com.aking.wanandroid.util.AppLog
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Created by Rick on 2022-08-16  15:55.
 * God bless my code!
 * @Description:
 */
class SearchRepository : BaseRepository {

    private val service = RetrofitManager.getService(SearchService::class.java)

    suspend fun getHotKeyList() = flow { emit(service.getSearchHotKey()) }.catch {
        AppLog.e(msg = it.message.toString())
    }

    fun getDailyRecommendSongs() = flow { emit(service.getDailyRecommendSongs()) }.catch {
        AppLog.e(msg = it.message.toString())
    }.asLiveData()
}