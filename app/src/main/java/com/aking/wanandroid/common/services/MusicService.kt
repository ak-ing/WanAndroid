package com.aking.wanandroid.common.services

import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.http.adapter.NetworkResponse
import com.aking.wanandroid.common.services.bean.SongUrlData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by AK on 2022/8/18 20:10.
 * God bless my code!
 */
interface MusicService : BaseService {

    /**
     * 获取歌曲Url
     */
    @GET("/song/url")
    suspend fun getSongUrlById(@Query("id") ids: String): NetworkResponse<SongUrlData>

}