package com.aking.wanandroid

import android.os.Bundle
import com.aking.wanandroid.ui.vdb.ActivityDataBindingDelegate
import com.aking.wanandroid.app.base.VDBaseActivity
import com.aking.wanandroid.databinding.ActivityMainBinding

class MainActivity : VDBaseActivity() {

    override val vdb: ActivityMainBinding by ActivityDataBindingDelegate(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}