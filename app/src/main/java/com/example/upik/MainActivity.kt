package com.example.upik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.LOGIN).setOnClickListener {
            val intent = Intent(this,LOGIN::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.SIGNUP).setOnClickListener {
            val intent = Intent(this,SIGNUP::class.java)
            startActivity(intent)
        }
    }
}