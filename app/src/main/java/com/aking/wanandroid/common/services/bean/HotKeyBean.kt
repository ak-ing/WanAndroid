package com.aking.wanandroid.common.services.bean

/**
 * Created by Rick on 2022-08-16  16:59.
 * God bless my code!
 * @Description: 热搜列表(简略)
 */
data class HotKeyBean(
    val hots: List<Hot>
)

data class Hot(
    val first: String,
    val iconType: Int,
    val second: Int,
    val third: Any
)