package com.example.mythproject.model

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mythproject.R

class SecondActivity: AppCompatActivity() {

    lateinit var mythName: TextView
    lateinit var mythText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mythName = findViewById(R.id.mythName)
        mythText = findViewById(R.id.mythText)

        mythName.text = intent.extras?.getString("namePosition")
        mythText.text = intent.extras?.getString("assets")

    }
}