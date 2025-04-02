package com.example.kotlinknowledge

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({ //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(
                this@SplashScreenActivity,
                MainActivity::class.java
            )
            startActivity(i)
            // close this activity
            finish()
        }, 3000)
    }
}