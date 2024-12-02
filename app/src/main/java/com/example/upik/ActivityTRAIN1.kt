package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.Button

class ActivityTRAIN1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train1)

        findViewById<ImageView>(R.id.backTrain1).setOnClickListener {
            finish()
        }

        val buttonSelesai = findViewById<Button>(R.id.button_selesai1)
        buttonSelesai.setOnClickListener {
            // Simpan progress setelah latihan selesai
            saveProgress(1) // Misalnya, 1 menunjukkan Hari 1 telah selesai
            Toast.makeText(this, "Progress berhasil disimpan!", Toast.LENGTH_SHORT).show()
            finish() // Menutup activity ini
        }
    }

    private fun saveProgress(day: Int) {
        // Simpan progres di SharedPreferences
        val sharedPreferences = getSharedPreferences("WorkoutProgress", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("PROGRESS_DAY", day) // Simpan hari terakhir yang diselesaikan
        editor.apply() // Simpan perubahan
    }
}