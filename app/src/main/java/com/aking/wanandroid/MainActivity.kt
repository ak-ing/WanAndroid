package com.aking.wanandroid

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aking.wanandroid.app.base.VDBaseActivity
import com.aking.wanandroid.widgets.NavBottomViewDoubleClickListener
import com.aking.wanandroid.widgets.ActivityDataBindingDelegate
import com.aking.wanandroid.databinding.ActivityMainBinding
import com.aking.wanandroid.util.getPrimaryColor

class MainActivity : VDBaseActivity() {

    override val vdb: ActivityMainBinding by ActivityDataBindingDelegate(R.layout.activity_main)
    private val vm: MainViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        with(vdb) {
            navView.setupWithNavController(navHostFragment.findNavController())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vdb.navView.setOnItemSelectedListener(NavBottomViewDoubleClickListener(this::onBottomDoubleClick))
    }

    private fun changeProfileDot(isShown: Boolean) {
        vdb.navView.getOrCreateBadge(R.id.navigation_profile).also { badge ->
            badge.backgroundColor = getPrimaryColor()
            badge.isVisible = isShown
        }
    }

    private fun onBottomDoubleClick(item: MenuItem) {
        // TODO: 双击回到顶部
    }

}