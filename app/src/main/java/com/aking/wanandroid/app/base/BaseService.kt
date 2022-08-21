package com.aking.wanandroid.app.base

import com.aking.wanandroid.common.http.adapter.NetworkResponse
import com.aking.wanandroid.common.services.bean.SongUrlData
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseService {

    companion object {

        /**
         * 默认初始页数
         */
        const val DEFAULT_PAGE_START_NO = 0

        const val DEFAULT_PAGE_START_NO_1 = 1
    }

    /**
     * 获取歌曲Url
     */
    @GET("/song/url")
    suspend fun getSongUrlById(@Query("id") ids: String): NetworkResponse<SongUrlData>

    /**
     * 匿名登录
     */
    @GET("/register/anonimous")
    suspend fun registerByAnonymous(): NetworkResponse<String>

}