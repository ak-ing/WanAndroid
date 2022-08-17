package com.aking.wanandroid.ui.search

import com.aking.wanandroid.common.http.RetrofitManager
import com.aking.wanandroid.common.services.SearchService

/**
 * Created by Rick on 2022-08-16  15:55.
 * God bless my code!
 * @Description:
 */
class SearchRepository {

    private val service = RetrofitManager.getService(SearchService::class.java)

    suspend fun getHotKeyList() = service.getSearchHotKey()

}