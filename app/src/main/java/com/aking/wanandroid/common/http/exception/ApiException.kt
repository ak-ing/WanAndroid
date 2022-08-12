package com.aking.wanandroid.common.http.exception

/**
 * Created by Rick on 2022-08-12  17:58.
 * God bless my code!
 * @Description:
 */
class ApiException(val code: Int, override val message: String?) : RuntimeException(message) {

    companion object {
        private const val serialVersionUID: Long = -77705430766904704L

        const val CODE_NOT_LOGGED_IN = -1001
    }

    fun isNotLogged() = code == CODE_NOT_LOGGED_IN

}