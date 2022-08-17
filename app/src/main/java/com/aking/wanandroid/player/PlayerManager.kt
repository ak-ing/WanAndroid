package com.aking.wanandroid.player

import android.content.Context
import com.aking.wanandroid.player.bean.BaseAlbum
import com.aking.wanandroid.player.controller.ICacheProxy
import com.aking.wanandroid.player.controller.IPlayerController
import com.danikula.videocache.HttpProxyCacheServer

/**
 * Created by Rick on 2022-08-17  12:21.
 * God bless my code!
 * @Description: 播放管理器-->全局单例
 */
object PlayerManager : IPlayerController {

    private val mController = PlayerController()

    override fun init(context: Context) {
        this.init(context) { it ->
            HttpProxyCacheServer.Builder(context)
                .fileNameGenerator { it.split("/").last() }
                .maxCacheSize(1073741824L) // 1GB
                .build()
                .getProxyUrl(it)
        }
    }

    /**
     * 初始化，设置缓存代理
     */
    fun init(context: Context, cacheProxy: ICacheProxy) {
        mController.setCacheProxy(cacheProxy)
    }

    override fun loadAlbum(album: BaseAlbum) {
        TODO("Not yet implemented")
    }

    override fun loadAlbum(album: BaseAlbum, playIndex: Int) {
        TODO("Not yet implemented")
    }

    override fun playAudio() {
        TODO("Not yet implemented")
    }

    override fun playAudio(index: Int) {
        TODO("Not yet implemented")
    }

    override fun playNext() {
        TODO("Not yet implemented")
    }

    override fun playPrevious() {
        TODO("Not yet implemented")
    }

    override fun playAgain() {
        TODO("Not yet implemented")
    }

    override fun togglePlay() {
        TODO("Not yet implemented")
    }

    override fun pauseAudio() {
        TODO("Not yet implemented")
    }

    override fun resumeAudio() {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun changeMode() {
        TODO("Not yet implemented")
    }

    override fun isPlaying(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isPaused(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isInit(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setSeek(progress: Int) {
        TODO("Not yet implemented")
    }

    override fun getTrackTime(progress: Int): String? {
        TODO("Not yet implemented")
    }


}