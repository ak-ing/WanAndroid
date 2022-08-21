package com.aking.wanandroid.app

import android.app.Application
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.http.adapter.getOrElse
import com.aking.wanandroid.player.PlayerManager
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.COOKIE_KEY
import com.aking.wanandroid.util.dataStore
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.map

/**
 * Created by AK on 2022/8/14 22:15.
 * God bless my code!
 */
class App : Application(), ViewModelStoreOwner {

    companion object {
        private lateinit var sApp: App

        @JvmStatic
        fun instance() = sApp
    }

    private val mAppViewModelStore = ViewModelStore()
    private var mCookie: String = ""

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
        ioApplicationScope.launch {
            dataStore.data.map { it[COOKIE_KEY] }.collect { mCookie = it ?: "" }
        }
//        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    /**
     * 获取Cookie
     */
    suspend fun getCookie(service: BaseService): String {
        if (mCookie.isEmpty()) {
            ioApplicationScope.launch {
                mCookie = service.registerByAnonymous().getOrElse { "" }
            }.join()
            dataStore.edit { it[COOKIE_KEY] = mCookie }
        }
        return mCookie
    }

    override fun getViewModelStore() = mAppViewModelStore

}