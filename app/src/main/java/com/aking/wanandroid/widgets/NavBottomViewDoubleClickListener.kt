package com.aking.wanandroid.widgets

import android.os.SystemClock
import android.view.MenuItem
import com.google.android.material.navigation.NavigationBarView

/**
 * Created by Rick on 2022-08-16  11:47.
 * God bless my code!
 * @Description: 底部导航栏双击
 */
class NavBottomViewDoubleClickListener(
    private val onItemDoubleClick: ((MenuItem) -> Unit)
) : NavigationBarView.OnItemSelectedListener {

    companion object {
        private const val DEFAULT_QUICK_CLICK_DURATION = 200L
    }

    private var timestampLastClick = 0L
    private var lastClickItemId = 0

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (SystemClock.elapsedRealtime() - timestampLastClick < DEFAULT_QUICK_CLICK_DURATION && item.itemId == lastClickItemId) {
            onItemDoubleClick(item)
        }
        lastClickItemId = item.itemId
        timestampLastClick = SystemClock.elapsedRealtime()
        return true
    }
}