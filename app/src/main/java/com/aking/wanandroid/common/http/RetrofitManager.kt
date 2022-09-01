package com.aking.wanandroid.common.http

import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.http.adapter.ErrorHandler
import com.aking.wanandroid.common.http.adapter.NetworkResponseAdapterFactory
import com.aking.wanandroid.common.http.converter.GsonConverterFactory
import com.aking.wanandroid.util.AppLog
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

/**
 * Retrofit管理类
 */
object RetrofitManager {

    const val BASE_URL = "http://music.akcoming.top"

    private val servicesMap = ConcurrentHashMap<String, BaseService>()
    private val errorHandlers = mutableListOf<ErrorHandler>()

    private val logInterceptor by lazy {
        HttpLoggingInterceptor { }.setLevel(if (AppLog.ISDEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC)
    }

    fun addErrorHandlerListener(handler: ErrorHandler) {
        errorHandlers.add(handler)
    }

    //构建okhttp
    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            //添加公共heads
            .addInterceptor(CookieInterceptor())
            .addInterceptor(AddCookieInterceptor())
            // 日志拦截器
            .addInterceptor(logInterceptor)
            .connectionPool(ConnectionPool(8, 15, TimeUnit.SECONDS))
            //超时时间 连接、读、写
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : BaseService> getService(serviceClass: Class<T>, baseUrl: String? = null): T {
        return servicesMap.getOrPut(serviceClass.name) {
            Retrofit.Builder()
                .client(getOkHttpClient())
                .addCallAdapterFactory(NetworkResponseAdapterFactory(object : ErrorHandler {
                    override fun bizError(code: Int, msg: String) {
                        errorHandlers.forEach { it.bizError(code, msg) }
                        AppLog.d(msg = "bizError: code:$code - msg: $msg")
                    }

                    override fun otherError(throwable: Throwable) {
                        errorHandlers.forEach { it.otherError(throwable) }
                        AppLog.e(msg = throwable.message.toString(), throwable = throwable)
                    }
                }))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl ?: BASE_URL)
                .build()
                .create(serviceClass)
        } as T
    }

}