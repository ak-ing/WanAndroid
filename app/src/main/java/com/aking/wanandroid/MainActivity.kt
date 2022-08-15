package com.aking.wanandroid

import android.os.Bundle
import com.aking.wanandroid.base.ActivityDataBindingDelegate
import com.aking.wanandroid.base.VDBaseActivity
import com.aking.wanandroid.databinding.ActivityMainBinding

class MainActivity : VDBaseActivity() {

    override val viewDataBinding: ActivityMainBinding by ActivityDataBindingDelegate(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.tvText.text = "test"
    }

}