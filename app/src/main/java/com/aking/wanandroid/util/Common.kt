package com.aking.wanandroid.util

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.util.TypedValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.aking.wanandroid.R
import com.google.android.material.color.MaterialColors

/**
 * Created by Rick on 2022-08-18  18:16.
 * God bless my code!
 * @Description:
 */

/**
 * dataStore
 */
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


/**
 * TAG
 */
val Any.TAG get() = this::class.java.simpleName + ":" + Integer.toHexString(hashCode())


/**
 * dp单位
 */
val Number.dp get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics)


/**
 * 获取Primary Color
 */
fun Context.getPrimaryColor() = MaterialColors.getColor(
    this,
    com.google.android.material.R.attr.colorPrimary,
    getColor(R.color.md_theme_primary)
)


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