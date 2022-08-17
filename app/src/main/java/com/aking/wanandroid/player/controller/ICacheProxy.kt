package com.aking.wanandroid.player.controller

/**
 * Created by Rick on 2022-08-17  17:22.
 * God bless my code!
 * @Description: 缓存代理接口
 */
fun interface ICacheProxy {
    fun getCacheUrl(url: String): String
}