package com.aking.wanandroid.app.base

import androidx.databinding.ViewDataBinding

/**
 * Created by Rick on 2022-08-15  17:19.
 * God bless my code!
 * @Description: DataBinding基类Activity
 */
abstract class VDBaseActivity : BaseActivity() {

    protected abstract val vdb: ViewDataBinding

}