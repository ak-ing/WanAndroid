package com.aking.wanandroid.player

import com.aking.wanandroid.player.bean.BaseAlbum
import com.aking.wanandroid.player.bean.BaseSong

/**
 * Created by AK on 2022/8/17 22:14.
 * God bless my code!
 * @Description: 播放信息管理
 */
class PlayingInfoManager {

    /**
     * 当前播放的索引,可能是随机播放的
     */
    private var mPlayIndex = 0

    /**
     * 播放列表中的位置
     */
    private var mCurrentIndex = 0

    //播放模式
    private var mRepeatMode = RepeatMode.LIST_CYCLE

    //原始列表
    private val mOriginPlayingList = arrayListOf<BaseSong>()

    //随机播放列表
    private val mShufflePlayingList = arrayListOf<BaseSong>()

    //专辑详情
    private var mAlbum: BaseAlbum? = null

    /**
     * 设置歌曲列表
     */
    fun setSongs(songs: List<BaseSong>) {
        mOriginPlayingList.clear()
        mOriginPlayingList.addAll(songs)
        fitShuffle()
    }

    /**
     * 获取专辑信息
     */
    fun getAlbum() = mAlbum

    /**
     * 设置专辑信息
     */
    fun setAlbum(musicAlbum: BaseAlbum) {
        this.mAlbum = musicAlbum
    }

    /**
     * 获取播放列表中的位置
     */
    fun getCurrentIndex() = mCurrentIndex

    /**
     * 设置播放的位置
     */
    fun setCurrentIndex(currentIndex: Int) {
        mCurrentIndex = currentIndex
        mPlayIndex = getPlayingList().indexOf(mOriginPlayingList[mCurrentIndex])
    }

    /**
     * 获取当前播放模式
     */
    fun getRepeatMode() = mRepeatMode

    /**
     * 切换播放模式
     */
    fun changeMode(): RepeatMode = mRepeatMode.also {
        when (mRepeatMode) {
            RepeatMode.SINGLE_CYCLE -> RepeatMode.RANDOM
            RepeatMode.RANDOM -> RepeatMode.LIST_CYCLE
            else -> RepeatMode.SINGLE_CYCLE
        }
    }

    /**
     * 获取播放列表
     */
    fun getPlayingList() = if (mRepeatMode == RepeatMode.RANDOM) {
        mShufflePlayingList
    } else {
        mOriginPlayingList
    }

    /**
     * 获取源列表
     */
    fun getOriginPlayList() = mOriginPlayingList

    /**
     * 随机打乱列表
     */
    private fun fitShuffle() = mShufflePlayingList.shuffle()

    /**
     * 获取当前播放的歌曲。如果是空列表，返回null
     */
    fun getCurrentPlayingMusic() = if (getPlayingList().isEmpty()) null else getPlayingList()[mPlayIndex]

    /**
     * 计算上一个索引
     */
    fun countPreviousIndex() {
        if (mPlayIndex == 0) {
            mPlayIndex = getPlayingList().size - 1
        } else {
            --mPlayIndex
        }
        mCurrentIndex = mOriginPlayingList.indexOf(getCurrentPlayingMusic())
    }

    /**
     * 计算下一个索引
     */
    fun countNextIndex() {
        if (mPlayIndex == getPlayingList().size - 1) {
            mPlayIndex = 0
        } else {
            ++mPlayIndex
        }
        mCurrentIndex = mOriginPlayingList.indexOf(getCurrentPlayingMusic())
    }

    enum class RepeatMode {
        SINGLE_CYCLE, LIST_CYCLE, RANDOM
    }
}