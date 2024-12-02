package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ResepRotiGandum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resep_roti_gandum)

        findViewById<ImageView>(R.id.backSandwichGandum).setOnClickListener {
            finish()
        }
    }
}