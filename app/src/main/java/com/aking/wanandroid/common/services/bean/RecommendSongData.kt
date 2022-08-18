package com.aking.wanandroid.common.services.bean

import com.aking.wanandroid.player.bean.BaseSong

/**
 * Created by AK on 2022/8/18 20:11.
 * God bless my code!
 */
data class RecommendSongData(
    val dailySongs: List<DailySong>,
    val recommendReasons: List<RecommendReason>
)

data class DailySong(
    val a: Any,
    val alg: String,
    val alia: List<Any>,
    val cd: String,
    val cf: String,
    val copyright: Int,
    val cp: Int,
    val crbt: Any,
    val djId: Int,
    val dt: Int,
    val entertainmentTags: Any,
    val fee: Int,
    val ftype: Int,
    val hr: Any,
    val mark: Int,
    val mst: Int,
    val mv: Int,
    val no: Int,
    val noCopyrightRcmd: Any,
    val originCoverType: Int,
    val originSongSimpleData: Any,
    val pop: Int,
    val pst: Int,
    val publishTime: Long,
    val reason: String,
    val resourceState: Boolean,
    val rt: String,
    val rtUrl: Any,
    val rtUrls: List<Any>,
    val rtype: Int,
    val rurl: Any,
    val s_ctrp: String,
    val s_id: Int,
    val single: Int,
    val songJumpInfo: Any,
    val st: Int,
    val t: Int,
    val tagPicList: Any,
    val tns: List<String>,
    val v: Int,
    val version: Int, override val name: String, override val id: Long
) : BaseSong()

data class RecommendReason(
    val reason: String,
    val songId: Int
)
