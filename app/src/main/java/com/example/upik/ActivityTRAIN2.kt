package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ActivityTRAIN2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train2)

        findViewById<ImageView>(R.id.backTrain2).setOnClickListener {
            finish()
        }

        val buttonSelesai = findViewById<Button>(R.id.button_selesai2)
        buttonSelesai.setOnClickListener {
            // Simpan progress setelah latihan selesai
            saveProgress(2) // Misalnya, 1 menunjukkan Hari 1 telah selesai
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