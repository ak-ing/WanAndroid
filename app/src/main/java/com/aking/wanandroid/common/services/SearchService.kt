package com.aking.wanandroid.common.services

import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.http.adapter.NetworkResponse
import com.aking.wanandroid.common.services.bean.HotKeyBean
import com.aking.wanandroid.common.services.bean.RecommendSongData
import retrofit2.http.GET
import retrofit2.http.Query

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

    /**
     * 获取每日推荐歌曲
     */
    @GET("/recommend/songs")
    suspend fun getDailyRecommendSongs(@Query("cookie") cookie: String): NetworkResponse<RecommendSongData>


}