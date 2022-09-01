package com.aking.wanandroid.common.http

import android.content.Context
import com.aking.wanandroid.app.App
import com.aking.wanandroid.util.COOKIE_KEY
import com.aking.wanandroid.util.SHARED_PREFERENCES
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by AK on 2022/9/1 0:53.
 * God bless my code!
 */
class AddCookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val sp = App.get().getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val cookie = sp.getString(COOKIE_KEY, null)
        cookie?.let {
            builder.addHeader("Cookie", it);
        }

        return chain.proceed(builder.build())
    }
}