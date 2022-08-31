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


