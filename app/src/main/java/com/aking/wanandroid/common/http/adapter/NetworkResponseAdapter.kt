package com.aking.wanandroid.common.http.adapter

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by Rick on 2022-08-12  16:32.
 * God bless my code!
 * @Description:
 */
class NetworkResponseAdapter(private val successType: Type, private val errorHandler: ErrorHandler?) :
    CallAdapter<Any, Call<Any>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<Any>): Call<Any> =
        NetWorkResponseCall(call, successType as ParameterizedType, errorHandler)
}