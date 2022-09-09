package com.aking.wanandroid.common.services

import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.http.adapter.NetworkResponse
import retrofit2.http.GET

/**
 * Created by Rick on 2022-09-07  14:36.
 * God bless my code!
 * @Description:
 */
interface UserService : BaseService {

    /**
     * 匿名登录
     */
    @GET("/register/anonimous")
    suspend fun registerByAnonymous(): NetworkResponse<String>


}