package com.aking.wanandroid.common.http

import android.content.Context
import androidx.core.content.edit
import com.aking.wanandroid.app.App
import com.aking.wanandroid.util.COOKIE_KEY
import com.aking.wanandroid.util.SHARED_PREFERENCES
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Cookie及通用头信息拦截器
 * Created by AK on 2022/8/31 23:49.
 * God bless my code!
 */
class CookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalResponse = chain.proceed(chain.request())

        val headers = originalResponse.headers("Set-Cookie")
        if (headers.isNotEmpty()) {
            headers.find { it.contains("MUSIC_A=") }?.let {
                val sp = App.get().getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
                sp.edit { putString(COOKIE_KEY, it.split(";").first()) }
            }
        }

        return originalResponse
    }
}