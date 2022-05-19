package md.sestra.udianork

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import kotlinx.coroutines.*
import md.sestra.udianork.fragments.SplashFragment
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    var player: MediaPlayer? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val w: Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        ) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_main)
        player = MediaPlayer.create(this, R.raw.latinophonic)
        async {
            delay(2500)
            play()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flContainerFragments, SplashFragment())
            .commit()
    }

    override fun onResume() {
        super.onResume()
        val w: Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        ) //появляется поверх активити и исчезает
    }

    private fun play() {
        player?.start()
    }

    private fun stopPlay() {
        player?.stop()
        player?.prepare()
        player?.seekTo(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (player?.isPlaying!!) {
            stopPlay()
        }
    }
}