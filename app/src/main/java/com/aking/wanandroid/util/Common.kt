package com.aking.wanandroid.util

import android.content.res.Resources
import android.util.TypedValue

/**
 * Created by Rick on 2022-08-18  18:16.
 * God bless my code!
 * @Description:
 */

/**
 * TAG
 */
val Any.TAG get() = javaClass.simpleName + ":" + Integer.toHexString(hashCode())


/**
 * dp单位
 */
val Number.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )


