package com.aking.wanandroid.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.TAG

/**
 * Created by Rick on 2022-08-15  17:08.
 * God bless my code!
 * @Description: Fragment基类
 */
class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        AppLog.d(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppLog.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AppLog.d(TAG, "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AppLog.d(TAG, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        AppLog.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        AppLog.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        AppLog.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        AppLog.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        AppLog.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        AppLog.d(TAG, "onDestroy")
        super.onDestroy()
    }

}