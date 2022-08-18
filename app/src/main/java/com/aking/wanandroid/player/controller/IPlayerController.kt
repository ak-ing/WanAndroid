package com.aking.wanandroid.player.controller

import android.content.Context
import com.aking.wanandroid.player.bean.BaseAlbum
import com.aking.wanandroid.player.bean.BaseSong

/**
 * Created by Rick on 2022-08-17  12:22.
 * God bless my code!
 * @Description: 控制器功能定义
 */
interface IPlayerController {

    /**
     * 执行初始化
     */
    fun init(context: Context)

    /**
     * 载入播放列表
     */
    fun loadSongs(songs: List<BaseSong>)

    /**
     * 载入播放列表
     */
    fun loadSongs(songs: List<BaseSong>, playIndex: Int)

    /**
     * 播放音乐
     */
    fun playAudio()

    /**
     * 播放index处的音乐
     */
    fun playAudio(index: Int)

    /**
     * 手动点击，和自动next，都调用这个
     */
    fun playNext()

    /**
     * 播放上一首
     */
    fun playPrevious()

    /**
     * 再次播放
     */
    fun playAgain()

    /**
     * 点击播放按钮
     */
    fun togglePlay()

    /**
     * 播放暂停
     */
    fun pauseAudio()

    /**
     * 播放继续
     */
    fun resumeAudio()

    /**
     * 状态清除
     */
    fun clear()

    /**
     * 切换播放模式
     */
    fun changeMode()

    /**
     * 是否播放中
     */
    fun isPlaying(): Boolean

    /**
     * 是否已经暂停
     */
    fun isPaused(): Boolean

    /**
     * 设置进度
     */
    fun setSeek(progress: Int)

    /**
     * 传入进度，返回播放时间
     */
    fun getTrackTime(progress: Int): String?


}