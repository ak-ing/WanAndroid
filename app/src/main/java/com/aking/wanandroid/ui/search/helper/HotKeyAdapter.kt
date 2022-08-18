package com.aking.wanandroid.ui.search.helper

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aking.wanandroid.common.services.bean.Hot
import com.aking.wanandroid.ui.view.TagsAdapter


/**
 * Created by Rick on 2022-08-18  14:43.
 * God bless my code!
 * @Description: 热搜词3D适配器
 */
class HotKeyAdapter : TagsAdapter() {

    private val hotKeys = arrayListOf<Hot>()

    fun submitList(tags: List<Hot>) {
        hotKeys.clear()
        hotKeys.addAll(tags)
        notifyDataSetChanged()
    }

    override fun getCount(): Int = hotKeys.size

    override fun getView(context: Context?, position: Int, parent: ViewGroup?): View {
        val item = hotKeys[position]
        return TextView(context).also {
            it.text = item.first
        }
    }

    override fun getItem(position: Int): Hot = hotKeys[position]

    override fun getPopularity(position: Int): Int {
        return position % 5;
    }

    override fun onThemeColorChanged(view: View, themeColor: Int) {
//        view.findViewById<TextView>(R.id.android_eye).setBackgroundColor(themeColor)

//        val color: Int = Color.argb(((1 - alpha) * 255) as Int, 255, 255, 255)
//        (view.findViewById(R.id.iv) as ImageView).setColorFilter(color)
    }
}