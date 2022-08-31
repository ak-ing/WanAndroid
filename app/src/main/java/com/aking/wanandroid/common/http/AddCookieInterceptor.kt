package com.aking.wanandroid.common.http

import android.content.Context
import com.aking.wanandroid.app.App
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by AK on 2022/9/1 0:53.
 * God bless my code!
 */
class AddCookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val sp = App.get().getSharedPreferences("config", Context.MODE_PRIVATE)
        val cookies = sp.getString("cookie", null)
        cookies?.let {
            builder.addHeader("cookie", it);
        }

        return chain.proceed(builder.build())
    }
}