package com.aking.wanandroid

import com.aking.wanandroid.app.base.BaseRepository
import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.http.RetrofitManager

/**
 * Created by AK on 2022/8/21 21:10.
 * God bless my code!
 */
class MainRepository : BaseRepository {

    private val service = RetrofitManager.getService(BaseService::class.java)

    override fun getService(): BaseService = service

    /**
     * 匿名登录
     */
    suspend fun registerByAnonymous() = service.registerByAnonymous()

}