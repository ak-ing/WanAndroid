package com.aking.wanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.TAG

/**
 * Created by Rick on 2022-08-15  10:47.
 * God bless my code!
 * @Description: Actvitiy基类
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppLog.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        AppLog.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestart() {
        AppLog.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onResume() {
        AppLog.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        AppLog.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        AppLog.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        AppLog.d(TAG, "onDestroy")
        super.onDestroy()
    }

}