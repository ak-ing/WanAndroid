package com.aking.wanandroid.common.repository

import com.aking.wanandroid.common.http.RetrofitManager
import com.aking.wanandroid.common.services.UserService

/**
 * Created by Rick on 2022-09-07  14:33.
 * God bless my code!
 * @Description: 用户存储库
 */
class UserRepository {

    private val service = RetrofitManager.getService(UserService::class.java)


    /**
     * 匿名登录
     */
    suspend fun registerByAnonymous() = service.registerByAnonymous()

}