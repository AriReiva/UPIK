package com.example.upik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Activity_salad_bowl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salad_bowl)

        findViewById<ImageView>(R.id.backSalabowl).setOnClickListener {
            finish()
        }
    }
}