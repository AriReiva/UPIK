package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ActivityResepCapcay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep_capcay)

        findViewById<ImageView>(R.id.backcapcay).setOnClickListener {
            finish()
        }
    }
}