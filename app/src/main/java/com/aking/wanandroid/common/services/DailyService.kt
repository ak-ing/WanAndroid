package com.aking.wanandroid.common.services

import com.aking.wanandroid.common.http.adapter.NetworkResponse
import com.aking.wanandroid.common.services.bean.RecommendSongData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by AK on 2022/8/18 20:10.
 * God bless my code!
 */
interface DailyService : BaseService {

    /**
     * 获取每日推荐歌曲
     */
    @GET("/recommend/songs")
    suspend fun getDailyRecommendSongs(@Query("cookie") cookie: String): NetworkResponse<RecommendSongData>

    @GET("/register/anonimous")
    suspend fun registerByAnonymous(): NetworkResponse<String>

}