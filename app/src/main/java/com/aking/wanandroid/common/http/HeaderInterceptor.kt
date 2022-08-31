package com.aking.wanandroid.common.http

import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val commonParams: MutableMap<String, Any?> = HashMap()
//        commonParams["_rt"] = System.currentTimeMillis().toString() //请求时间戳
//        commonParams["aid"] = Constant.AID //账号ID
//        commonParams["app_id"] = Constant.APP_ID//分配的appId
//        commonParams["appId"] = Constant.APPID
//        commonParams["nonce"] = SignUtils.generateRandomNum(32) //随机字符串
        val method = request.method
        var httpUrl = request.url
        if (method == "GET") {
            val builder = request.url.newBuilder()
            //添加公共参数
            for ((key, value) in commonParams) {
                builder.addQueryParameter(key, value.toString())
            }
            val paramKeys = httpUrl.queryParameterNames
            for (key in paramKeys) {
                val value = httpUrl.queryParameter(key)
                commonParams[key] = value
            }
//            builder.addQueryParameter("sign",
//                SignUtils.generateSign(commonParams, Constant.SECRET))
            httpUrl = builder.build()
        } else if (method == "POST") {
        }
        val nRequest = request.newBuilder().url(httpUrl)
            .build()

        return chain.proceed(nRequest)
    }
}