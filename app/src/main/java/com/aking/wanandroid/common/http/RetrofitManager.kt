package com.aking.wanandroid.common.http

import com.aking.wanandroid.common.http.adapter.ErrorHandler
import com.aking.wanandroid.common.http.adapter.NetworkResponseAdapterFactory
import com.aking.wanandroid.common.http.converter.GsonConverterFactory
import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.util.AppLog
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

    private const val TIME_OUT_SECONDS = 10

//    private lateinit var cookieJarImpl: UserCookieJarImpl

    private val logInterceptor by lazy {
        HttpLoggingInterceptor { AppLog.d(msg = it) }.setLevel(if (AppLog.ISDEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC)
    }

    /** OkHttpClient相关配置 */
    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
//            .cookieJar(cookieJarImpl)
            .connectTimeout(TIME_OUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .build()

    private val servicesMap = ConcurrentHashMap<String, BaseService>()
    private val errorHandlers = mutableListOf<ErrorHandler>()

//    fun init(cookieJar: UserCookieJarImpl) {
//        cookieJarImpl = cookieJar
//        addErrorHandlerListener(ErrorToastHandler)
//    }

    fun addErrorHandlerListener(handler: ErrorHandler) {
        errorHandlers.add(handler)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : BaseService> getService(serviceClass: Class<T>, baseUrl: String? = null): T {
        return servicesMap.getOrPut(serviceClass.name) {
            Retrofit.Builder()
                .client(client)
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