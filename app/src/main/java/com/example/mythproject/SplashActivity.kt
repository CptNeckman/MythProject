package com.example.mythproject

import androidx.core.content.ContextCompat.startActivity

import com.example.mythproject.model.MainActivity

import android.content.Intent

import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {

    private val splashDisplayLength = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed(Runnable {
            run() {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, splashDisplayLength.toLong())
    }
}