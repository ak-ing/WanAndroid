package com.aking.wanandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aking.wanandroid.app.base.BaseViewModel

/**
 * Created by Rick on 2022-08-16  15:30.
 * God bless my code!
 * @Description:
 */
class MainViewModel : BaseViewModel() {

    private val repository = MainRepository()

    /**
     * 首页NavigationBottomTab双击事件
     */
    private val _mainTabDoubleClickLiveData = MutableLiveData<String>()
    val mainTabDoubleClickLiveData: LiveData<String> = _mainTabDoubleClickLiveData

    fun bottomDoubleClick(tag: String) {
        _mainTabDoubleClickLiveData.value = tag
    }

}