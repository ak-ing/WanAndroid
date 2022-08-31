package com.aking.wanandroid.common.http;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Token 及通用头信息拦截器
 */
public class TokenInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
//        builder.addHeader("appId", Constant.APPID);
//        builder.addHeader("token", TOKEN);

        return chain.proceed(builder.build());
    }
}
