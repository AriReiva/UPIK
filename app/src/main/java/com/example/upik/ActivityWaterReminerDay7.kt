package com.example.upik

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class ActivityWaterReminerDay7 : AppCompatActivity() {

    private var daysCompleted = BooleanArray(7) { false }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_reminer_day7)

        findViewById<ImageView>(R.id.BackWaterReminder).setOnClickListener {
            finish()
        }
        // Reference to the 7 buttons for each day
        val dayButtons = listOf<ImageButton>(
            findViewById(R.id.btnSunday),
            findViewById(R.id.btnMonday),
            findViewById(R.id.btnTuesday),
            findViewById(R.id.btnWednesday),
            findViewById(R.id.btnThursday),
            findViewById(R.id.btnFriday),
            findViewById(R.id.btnSaturday)
        )

        // Set up click listeners for each button to open the DailyWaterIntakeActivity for the selected day
        for (i in dayButtons.indices) {
            dayButtons[i].setOnClickListener {
                val intent = Intent(this, DailyWaterIntakeActivity::class.java)
                intent.putExtra("dayIndex", i) // Pass the day index (0 for Sunday, 1 for Monday, etc.)
                startActivityForResult(intent, i)
            }
        }
    }

    // Handle the result when the user completes 8 glasses for a day
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val isCompleted = data?.getBooleanExtra("isCompleted", false) ?: false
            if (isCompleted) {
                daysCompleted[requestCode] = true // Mark the day as completed
                updateDayButtonUI(requestCode) // Update the button UI
            }
        }
    }

    // Update the button UI for a completed day (e.g., change color)
    private fun updateDayButtonUI(dayIndex: Int) {
        val dayButtons = listOf<ImageButton>(
            findViewById(R.id.btnSunday),
            findViewById(R.id.btnMonday),
            findViewById(R.id.btnTuesday),
            findViewById(R.id.btnWednesday),
            findViewById(R.id.btnThursday),
            findViewById(R.id.btnFriday),
            findViewById(R.id.btnSaturday)
        )
        if (daysCompleted[dayIndex]) {
            dayButtons[dayIndex].setBackgroundResource(R.drawable.checked_background) // Change to completed color
        }
    }
}