package com.aking.wanandroid.common.http.adapter

/**
 * Created by Rick on 2022-08-12  17:11.
 * God bless my code!
 * @Description:用于配置全局的异常处理逻辑
 */
interface ErrorHandler {

    /**
     * 业务错误
     */
    fun bizError(code: Int, msg: String)

    /**
     * 其他错误
     */
    fun otherError(throwable: Throwable)
}