package com.aking.wanandroid.util

import android.content.Context
import com.aking.wanandroid.R
import com.google.android.material.color.MaterialColors

/**
 * Created by Rick on 2022-08-16  14:03.
 * God bless my code!
 * @Description:
 */

/**
 * 获取Primary Color
 */
fun Context.getPrimaryColor() = MaterialColors.getColor(
    this,
    com.google.android.material.R.attr.colorPrimary,
    getColor(R.color.md_theme_primary)
)