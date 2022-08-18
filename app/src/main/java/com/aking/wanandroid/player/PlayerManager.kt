package com.aking.wanandroid.player

import android.content.Context
import com.aking.wanandroid.player.bean.BaseSong
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
    private lateinit var mCacheProxy: HttpProxyCacheServer

    override fun init(context: Context) {
        mCacheProxy = HttpProxyCacheServer.Builder(context)
            .fileNameGenerator { it.split("/").last() }
            .maxCacheSize(1073741824L) // 1GB
            .build()
        this.init(context) { mCacheProxy.getProxyUrl(it) }
    }

    /**
     * 初始化，设置缓存代理
     */
    fun init(context: Context, cacheProxy: ICacheProxy) {
        mController.setCacheProxy(cacheProxy)
    }

    override fun loadSongs(songs: List<BaseSong>) = mController.loadSongs(songs)

    override fun loadSongs(songs: List<BaseSong>, playIndex: Int) = mController.loadSongs(songs, playIndex)

    override fun playAudio() = mController.playAudio()

    override fun playAudio(index: Int) = mController.playAudio(index)

    override fun playNext() = mController.playNext()

    override fun playPrevious() = mController.playPrevious()

    override fun playAgain() = mController.playAgain()

    override fun togglePlay() = mController.togglePlay()

    override fun pauseAudio() = mController.pauseAudio()

    override fun resumeAudio() = mController.resumeAudio()

    override fun clear() = mController.clear()

    override fun changeMode() = mController.changeMode()

    override fun isPlaying(): Boolean = mController.isPlaying()

    override fun isPaused(): Boolean = mController.isPaused()

    override fun setSeek(progress: Int) = mController.setSeek(progress)

    override fun getTrackTime(progress: Int): String = mController.getTrackTime(progress)


}