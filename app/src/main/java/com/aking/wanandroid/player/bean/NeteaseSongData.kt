package com.aking.wanandroid.player.bean

/**
 * Created by Rick on 2022-08-17  14:39.
 * God bless my code!
 * @Description: 标准网易云歌曲数据类
 */
data class NeteaseSongData(
    override val name: String,
    override val id: Long,
    val artists: ArrayList<NeteaseArtistData>,
    val album: NeteaseAlbumData,
) : BaseSong() {
    /**
     * 标准网易云艺术家类
     */
    data class NeteaseArtistData(
        override val name: String, override val id: Long, override val picUrl: String
    ) : BaseArtists()

    /**
     * 标准网易云专辑类
     */
    data class NeteaseAlbumData(
        override val id: Long, override val name: String, override val picUrl: String
    ) : BaseAlbum()
}