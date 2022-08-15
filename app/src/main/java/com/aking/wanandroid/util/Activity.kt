package com.aking.wanandroid.util

import android.content.Context
import android.content.Intent

/**
 * Created by Rick on 2022-08-15  17:16.
 * God bless my code!
 * @Description:
 */


/**
 * 在context作用域下启动一个新的Activity.
 *
 * @sample :
 * mContext.goActivity<TestActivity> {
 *    putExtra("param1", "data")
 *    putExtra("param2", 100)
 * }
 *
 * @param A 要跳转的Activity泛型.
 * @param block 在块作用域内以this作为intent值
 */
inline fun <reified A> Context.startActivity(noinline block: (Intent.() -> Unit)? = null) {
    Intent(this, A::class.java).run {
        startActivity(this.apply { block?.invoke(this) })
    }
}