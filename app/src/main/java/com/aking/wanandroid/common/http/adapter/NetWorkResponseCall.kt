package com.aking.wanandroid.common.http.adapter

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.reflect.ParameterizedType

/**
 * Created by Rick on 2022-08-12  16:54.
 * God bless my code!
 * @Description:
 */
class NetWorkResponseCall(
    private val delegate: Call<Any>,
    private val wrapperType: ParameterizedType,
    private val errorHandler: ErrorHandler?
) : Call<Any> {

    override fun enqueue(callback: Callback<Any>): Unit = delegate.enqueue(object : Callback<Any> {
        override fun onResponse(call: Call<Any>, response: Response<Any>) {
            // 无论请求响应成功还是失败都回调 Response.success
            if (response.isSuccessful) {
                val body = response.body()
                if (body is NetworkResponse.BizError) {
                    errorHandler?.bizError(body.errorCode, body.errorMessage)
                }
                callback.onResponse(this@NetWorkResponseCall, Response.success(body))
            } else {
                val exception = HttpException(response)
                errorHandler?.otherError(exception)
                callback.onResponse(
                    this@NetWorkResponseCall,
                    Response.success(NetworkResponse.UnknownError(exception))
                )
            }
        }

        override fun onFailure(call: Call<Any>, t: Throwable) {
            // 忽略请求被Canceled的情况
            if (call.isCanceled) {
                return
            }
            errorHandler?.otherError(t)
            callback.onResponse(this@NetWorkResponseCall, Response.success(NetworkResponse.UnknownError(t)))
        }
    })

    override fun cancel() {
        delegate.cancel()
    }

    override fun execute(): Response<Any> =
        throw UnsupportedOperationException("${this.javaClass.name} doesn't support execute.")

    override fun clone(): Call<Any> = NetWorkResponseCall(delegate, wrapperType, errorHandler)

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}