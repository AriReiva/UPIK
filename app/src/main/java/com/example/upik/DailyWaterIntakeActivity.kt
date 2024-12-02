package com.example.upik

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class DailyWaterIntakeActivity : AppCompatActivity() {

    private var waterIntake = BooleanArray(8) { false } // false by default (not completed)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_water_intake)

        findViewById<ImageView>(R.id.BackWaterDAY).setOnClickListener {
            finish()
        }

        // Setup buttons for each of the 8 glasses (e.g., 7am, 9am, 11am, etc.)
        val glassButtons = listOf<ImageButton>(
            findViewById(R.id.btnGlass1), // Example for 7am
            findViewById(R.id.btnGlass2), // Example for 9am
            findViewById(R.id.btnGlass3), // Example for 11am
            findViewById(R.id.btnGlass4), // Example for 12:30pm
            findViewById(R.id.btnGlass5), // Example for 2pm
            findViewById(R.id.btnGlass6), // Example for 3pm
            findViewById(R.id.btnGlass7), // Example for 4pm
            findViewById(R.id.btnGlass8)  // Example for 5pm
        )

        // Set up listeners for each button, updating the corresponding glass completion status
        for (i in glassButtons.indices) {
            glassButtons[i].setOnClickListener {
                waterIntake[i] = true // Mark this glass as completed
                glassButtons[i].setBackgroundResource(R.drawable.checked_background) // Change button color
                checkAllGlassesCompleted() // Check if all 8 glasses have been completed
            }
        }
    }

    // Check if all 8 glasses have been completed
    private fun checkAllGlassesCompleted() {
        if (waterIntake.all { it }) {
            // All glasses have been completed, send result back to Activity 1
            val resultIntent = Intent()
            val dayIndex = intent.getIntExtra("dayIndex", -1) // Get the day index passed from Activity 1
            resultIntent.putExtra("dayIndex", dayIndex)
            resultIntent.putExtra("isCompleted", true)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Close Activity 2 and return to Activity 1
        }
    }
}