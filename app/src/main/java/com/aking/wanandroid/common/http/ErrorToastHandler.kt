package com.aking.wanandroid.common.http

import com.aking.wanandroid.app.App
import com.aking.wanandroid.common.http.adapter.ErrorHandler
import com.aking.wanandroid.util.NetWorkUtil
import com.aking.wanandroid.util.showShortToast
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Error的Toast处理
 */
internal object ErrorToastHandler : ErrorHandler {

    private const val ERROR_DEFAULT = "请求失败"
    private const val ERROR_CONNECTED_TIME_OUT = "请求链接超时"
    private const val ERROR_NET_WORK_DISCONNECTED = "网络连接异常"

    private fun handle(throwable: Throwable): String =
        when (throwable) {
            is IOException -> {
                if (NetWorkUtil.isNetworkAvailable(App.instance()).not()) {
                    ERROR_NET_WORK_DISCONNECTED
                } else handIoException(throwable)
            }
            else -> ERROR_DEFAULT
        }

    override fun bizError(code: Int, msg: String) {
        msg.showShortToast()
    }

    override fun otherError(throwable: Throwable) {
        handle(throwable).showShortToast()
    }

    private fun handIoException(ioException: IOException): String {
        return when (ioException) {
            is SocketTimeoutException -> {
                ERROR_CONNECTED_TIME_OUT
            }
            else -> ERROR_DEFAULT
        }
    }
}