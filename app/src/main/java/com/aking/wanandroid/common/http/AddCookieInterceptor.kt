package com.aking.wanandroid.common.http

import android.content.Context
import com.aking.wanandroid.app.App
import com.aking.wanandroid.common.http.adapter.getOrNull
import com.aking.wanandroid.common.repository.UserRepository
import com.aking.wanandroid.util.COOKIE_KEY
import com.aking.wanandroid.util.SHARED_PREFERENCES
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by AK on 2022/9/1 0:53.
 * God bless my code!
 */
class AddCookieInterceptor : Interceptor {

    private val repository by lazy { UserRepository() }

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val sp = App.get().getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        var cookie = sp.getString(COOKIE_KEY, null)
        if (cookie == null) {
            App.get().ioApplicationScope.launch {
                cookie = repository.registerByAnonymous().getOrNull()
                addCookie(cookie, builder)
            }
        } else {
            addCookie(cookie, builder)
        }

        return chain.proceed(builder.build())
    }

    private fun addCookie(cookie: String?, builder: Request.Builder) {
        cookie?.let {
            builder.addHeader("Cookie", it);
        }
    }
}