package com.aking.wanandroid.player

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import com.aking.wanandroid.app.App
import com.aking.wanandroid.common.http.RetrofitManager
import com.aking.wanandroid.common.http.adapter.getOrElse
import com.aking.wanandroid.app.base.BaseService
import com.aking.wanandroid.common.services.bean.SongUrlData
import com.aking.wanandroid.player.bean.BaseSong
import com.aking.wanandroid.player.controller.ICacheProxy
import com.aking.wanandroid.player.controller.IPlayerController
import com.aking.wanandroid.util.AppLog
import com.aking.wanandroid.util.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Rick on 2022-08-17  15:33.
 * God bless my code!
 * @Description: 音乐播放控制器
 */
class PlayerController : IPlayerController {

    private val player = MediaPlayer()     //媒体对象
    private lateinit var mCacheProxy: ICacheProxy
    private val mPlayingInfoManager = PlayingInfoManager()
    private val service = RetrofitManager.getService(BaseService::class.java)

    private var mIsPaused = true
    private var mIsChangingPlayingMusic = false

    private val changeMusicLiveData = MutableLiveData<BaseSong>()
    private val playingMusicLiveData = MutableLiveData<BaseSong>()

    override fun init(context: Context) {
        player.run {
            setOnCompletionListener {
                if (mPlayingInfoManager.getRepeatMode() == PlayingInfoManager.RepeatMode.SINGLE_CYCLE) {
                    playAgain()
                } else {
                    playNext()
                }
            }
            setOnErrorListener { mp, what, extra ->

                true
            }
            setOnInfoListener { mp, what, extra -> true }
            setOnPreparedListener {
                start()
            }
            setOnSeekCompleteListener { }
            setOnBufferingUpdateListener { mp, percent -> }
        }
    }

    /**
     * 设置缓存代理
     */
    fun setCacheProxy(cacheProxy: ICacheProxy) {
        mCacheProxy = cacheProxy
    }

    override fun loadSongs(songs: List<BaseSong>) {
        setSongs(songs, 0)
    }

    override fun loadSongs(songs: List<BaseSong>, playIndex: Int) {
        setSongs(songs, playIndex)
        mIsChangingPlayingMusic = true
        if (player.isPlaying) {
            player.stop()
        }
        playAudio()
    }

    private fun setSongs(songs: List<BaseSong>, playIndex: Int) {
        mPlayingInfoManager.setSongs(songs)
        mPlayingInfoManager.setCurrentIndex(playIndex)
    }

    override fun playAudio() {
        if (mIsChangingPlayingMusic) {
            App.get().ioApplicationScope.launch(Dispatchers.IO) {
                runCatching {
                    player.reset()
                    player.setDataSource(mCacheProxy.getCacheUrl(getSongUrl()))
                    player.prepare()
                }.onFailure {
                    mIsChangingPlayingMusic = false
                    AppLog.d(TAG, "playAudio：播放失败")
                    it.printStackTrace()
                }.onSuccess {
                    mIsChangingPlayingMusic = false
                    player.start()
                }
            }
        } else if (mIsPaused) {
            resumeAudio()
        }
    }

    private suspend fun getSongUrl(): String {
        val songId = mPlayingInfoManager.getCurrentSongId().toString()
        val urlData = service.getSongUrlById(songId).getOrElse { SongUrlData() }
        val url = urlData[0].url.replace("http", "https")
        AppLog.d(TAG, url)
        return url
    }

    override fun playAudio(index: Int) {
        if (isPlaying() && mPlayingInfoManager.getCurrentIndex() == index) {
            return
        }
        mPlayingInfoManager.setCurrentIndex(index)
        mIsChangingPlayingMusic = true
        playAudio()
    }

    override fun playNext() {
        mPlayingInfoManager.countNextIndex()
        mIsChangingPlayingMusic = true
        playAudio()
    }

    override fun playPrevious() {
        mPlayingInfoManager.countPreviousIndex()
        mIsChangingPlayingMusic = true
        playAudio()
    }

    override fun playAgain() {
        mIsChangingPlayingMusic = true
        playAudio()
    }

    override fun togglePlay() {
        if (isPlaying()) pauseAudio() else playAudio()
    }

    override fun pauseAudio() {
        player.pause()
        mIsPaused = true
    }

    override fun resumeAudio() {
        if (!mIsChangingPlayingMusic) {
            mIsPaused = false
            player.start()
        }
    }

    override fun clear() {
        player.stop()
        player.reset()
    }

    override fun changeMode() {
        mPlayingInfoManager.changeMode()
    }

    override fun isPlaying(): Boolean = player.isPlaying

    override fun isPaused(): Boolean = mIsPaused

    override fun setSeek(progress: Int) {
        player.seekTo(progress)
    }

    override fun getTrackTime(progress: Int): String = calculateTime(progress)

    private fun calculateTime(time: Int): String {
        val minute: Int
        val second: Int
        return if (time >= 60) {
            minute = time / 60
            second = time % 60
            (if (minute < 10) "0$minute" else "" + minute) + if (second < 10) ":0$second" else ":$second"
        } else {
            second = time
            if (second < 10) {
                "00:0$second"
            } else "00:$second"
        }

    }
}