package com.aking.wanandroid.app

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.aking.wanandroid.player.PlayerManager
import com.aking.wanandroid.util.AppLog
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * Created by AK on 2022/8/14 22:15.
 * God bless my code!
 */
class App : Application(), ViewModelStoreOwner {

    companion object {
        private lateinit var sApp: App

        @JvmStatic
        fun get() = sApp
    }

    private val mAppViewModelStore = ViewModelStore()

    /**
     * 默认[Dispatchers.IO]
     */
    val ioApplicationScope by lazy {
        CoroutineScope(SupervisorJob() + Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            AppLog.e("IOApplicationScope:\n${throwable.message.toString()}", throwable = throwable)
        })
    }

    override fun onCreate() {
        super.onCreate()
        sApp = this
        PlayerManager.init(this)
//        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    override fun getViewModelStore() = mAppViewModelStore

}