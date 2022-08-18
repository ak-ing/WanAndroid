package com.aking.wanandroid.app

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.aking.wanandroid.player.PlayerManager

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

    override fun getViewModelStore() = mAppViewModelStore

    override fun onCreate() {
        super.onCreate()
        sApp = this
        PlayerManager.init(this)
//        DynamicColors.applyToActivitiesIfAvailable(this)
    }

}