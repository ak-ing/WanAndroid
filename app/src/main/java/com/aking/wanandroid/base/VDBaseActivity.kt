package com.aking.wanandroid.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding

/**
 * Created by Rick on 2022-08-15  17:19.
 * God bless my code!
 * @Description: DataBinding基类Activity
 */
abstract class VDBaseActivity : BaseActivity() {

    protected abstract val  viewDataBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}