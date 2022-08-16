package com.aking.wanandroid.common.services

import com.aking.wanandroid.common.http.adapter.NetworkResponse
import com.aking.wanandroid.common.services.bean.HotKeyBean
import retrofit2.http.GET

/**
 * Created by Rick on 2022-08-16  15:55.
 * God bless my code!
 * @Description:
 */
interface SearchService : BaseService {

    /**
     * 热搜列表(简略)
     */
    @GET("/search/hot")
    suspend fun getSearchHotKey(): NetworkResponse<HotKeyBean>

}