package com.aking.wanandroid.common.http

import android.content.Context
import androidx.core.content.edit
import com.aking.wanandroid.app.App
import com.aking.wanandroid.common.services.bean.CookieBean
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Cookie 及通用头信息拦截器
 * Created by AK on 2022/8/31 23:49.
 * God bless my code!
 */
class CookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalResponse = chain.proceed(chain.request())

        originalResponse.body?.let {
            val string = it.string()
            if (string.contains("cookie")) {
                val cookieBean = Gson().fromJson(string, CookieBean::class.java)

                val sp = App.get().getSharedPreferences("config", Context.MODE_PRIVATE)
                sp.edit { putString("cookie", cookieBean.cookie) }
            }
        }

        return originalResponse
    }
}