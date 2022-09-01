package com.aking.wanandroid

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aking.wanandroid.app.base.VDBaseActivity
import com.aking.wanandroid.databinding.ActivityMainBinding
import com.aking.wanandroid.widgets.*

class MainActivity : VDBaseActivity() {

    override val vdb: ActivityMainBinding by contentView(R.layout.activity_main)
    private val vm: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.init()
    }

    override fun onStart() {
        super.onStart()
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        vdb.run {
            val navController = navHostFragment.findNavController()
            navView.setOnItemSelectedListener(NavBottomViewDoubleClickListener(this@MainActivity::onBottomDoubleClick))
            navView.setupWithNavController(navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.playList, R.id.featured, R.id.search -> navView.show()
                    else -> navView.hide()
                }
            }
        }

    }

    private fun changeProfileDot(isShown: Boolean) {
        vdb.navView.getOrCreateBadge(R.id.featured).also { badge ->
            badge.backgroundColor = themeColor(com.google.android.material.R.attr.bottomNavigationStyle)
            badge.isVisible = isShown
        }
    }

    private fun onBottomDoubleClick(item: MenuItem) {
    }

}