package com.aking.wanandroid.common.services.bean

/**
 * Created by Rick on 2022-08-17  14:36.
 * God bless my code!
 * @Description: 推荐新音乐
 */
data class NewSongData(
    val code: Int,
    val result: ArrayList<ResultData>
) {
    data class ResultData(
        val id: Long,
        val name: String,
        val picUrl: String,
        val song: SongData
    ) {
        data class SongData(
            val fee: Int,
            val artists: ArrayList<NewSongArtistsData>,
            val album: AlbumData,
            val privilege: PrivilegeData
        ) {
            data class NewSongArtistsData(
                val name: String,
                val id: Long
            )
            data class AlbumData(
                val name: String,
                val id: Long
            )
            data class PrivilegeData(
                val pl: Int,
                val maxbr: Int,
                val flag: Int
            )
        }
    }
}