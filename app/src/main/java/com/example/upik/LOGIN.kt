package com.example.upik

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Context

class LOGIN : AppCompatActivity() {

    private lateinit var db: DATABASE
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = DATABASE(this)
        sharedPreferences = getSharedPreferences("userSession", Context.MODE_PRIVATE)


        val usernameEditText = findViewById<EditText>(R.id.userlogin)
        val passwordEditText = findViewById<EditText>(R.id.passlogin)
        val loginButton = findViewById<Button>(R.id.LOGIN_BUTTON)


        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val user = db.getUserByUsername(username)
            if (user != null && user.password == password) {
                val editor = sharedPreferences.edit()
                editor.putInt("userId", user.userId)
                editor.apply()

                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HOMEPAGE::class.java)
                startActivity(intent)
                finish() // Tutup halaman login
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}