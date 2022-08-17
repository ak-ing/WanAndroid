package com.aking.wanandroid.player

import android.content.Context
import com.aking.wanandroid.player.bean.BaseAlbum
import com.aking.wanandroid.player.controller.ICacheProxy
import com.aking.wanandroid.player.controller.IPlayerController

/**
 * Created by Rick on 2022-08-17  15:33.
 * God bless my code!
 * @Description: 音乐播放控制器
 */
class PlayerController : IPlayerController {

    private lateinit var mCacheProxy: ICacheProxy

    private val mIsPaused = false
    private val mIsChangingPlayingMusic = false

    override fun init(context: Context) {

    }

    /**
     * 设置缓存代理
     */
    fun setCacheProxy(cacheProxy: ICacheProxy) {
        mCacheProxy = cacheProxy
    }

    override fun loadAlbum(album: BaseAlbum) {

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