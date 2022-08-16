package com.aking.wanandroid.util

import android.util.Log

/**
 * App 日志类
 */
object AppLog {

    private const val DEFAULT_TAG = "WanAndroid"

    /**
     * Debug 下开启
     */
    const val ISDEBUG = true

    /**
     * [Log.VERBOSE]
     */
    fun v(tag: String = DEFAULT_TAG, msg: String) {
        if (ISDEBUG) {
            Log.v(tag, msg)
        }
    }

    /**
     * [Log.DEBUG]
     */
    fun d(tag: String = DEFAULT_TAG, msg: String) {
        if (ISDEBUG) {
            Log.d(tag, msg)
        }
    }

    /**
     * [Log.INFO]
     */
    fun i(tag: String = DEFAULT_TAG, msg: String) {
        if (ISDEBUG) {
            Log.i(tag, msg)
        }
    }

    /**
     * [Log.WARN]
     */
    fun w(tag: String = DEFAULT_TAG, msg: String) {
        if (ISDEBUG) {
            Log.w(tag, msg)
        }
    }

    /**
     * [Log.ERROR]
     */
    fun e(tag: String = DEFAULT_TAG, msg: String) {
        if (ISDEBUG) {
            Log.e(tag, msg)
        }
    }

    /**
     * [Log.ERROR]
     */
    fun e(tag: String = DEFAULT_TAG, msg: String = "", throwable: Throwable) {
        if (ISDEBUG) {
            Log.e(tag, msg, throwable)
        }
    }

}