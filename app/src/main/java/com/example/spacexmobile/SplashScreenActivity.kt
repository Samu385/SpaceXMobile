package com.example.spacexmobile

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIMEOUT: Long = 3000

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Colores de arriba y abajo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.Spektra_RojoRosado)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ContextCompat.getColor(this, R.color.Spektra_RojoRosado)
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.inicio)
        mediaPlayer.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            mediaPlayer.stop()
            startActivity(intent)
            finish()

        }, 2500)

    }
}