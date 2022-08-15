package com.aking.wanandroid.util

/**
 * Created by Rick on 2022-08-15  11:13.
 * God bless my code!
 */
val Any.TAG get() = this::class.java.simpleName + ":" + Integer.toHexString(hashCode())
