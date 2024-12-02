package com.example.upik

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

class FragmentTrain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_train, container, false)

        val trainingCategoryButton = view.findViewById<Button>(R.id.trainingCategory)
        val dropdownLayout = view.findViewById<LinearLayout>(R.id.dropdownLayout)

        // Handle Training Category button click with animation
        trainingCategoryButton.setOnClickListener {
            applyScaleAnimation(trainingCategoryButton)

            // Delay the scale-down animation after the scale-up finishes
            trainingCategoryButton.postDelayed({
                applyScaleDownAnimation(trainingCategoryButton)
            }, 200)

            // Toggle dropdown visibility logic
            if (dropdownLayout.visibility == View.GONE) {
                dropdownLayout.visibility = View.VISIBLE
            } else {
                dropdownLayout.visibility = View.GONE
            }
        }

        val buttonHari1 = view.findViewById<Button>(R.id.buttonDay1)
        buttonHari1.setOnClickListener {
            startWorkoutDay(1)
        }

        // Button for Day 2
        val buttonHari2 = view.findViewById<Button>(R.id.buttonDay2)
        buttonHari2.setOnClickListener {
            if (isDayUnlocked(2)) {
                startWorkoutDay(2)
            } else {
                Toast.makeText(requireContext(), "Hari 2 terkunci, selesaikan Hari sebelumnya", Toast.LENGTH_SHORT).show()
            }
        }

        // Button for Day 3
        val buttonHari3 = view.findViewById<Button>(R.id.buttonDay3)
        buttonHari3.setOnClickListener {
            if (isDayUnlocked(3)) {
                startWorkoutDay(3)
            } else {
                Toast.makeText(requireContext(), "Hari 3 terkunci, selesaikan Hari sebelumnya", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonHari4 = view.findViewById<Button>(R.id.buttonDay4)
        buttonHari4.setOnClickListener {
            if (isDayUnlocked(4)) {
                startWorkoutDay(4)
            } else {
                Toast.makeText(requireContext(), "Hari 4 terkunci, selesaikan Hari sebelumnya", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonHari5 = view.findViewById<Button>(R.id.buttonDay5)
        buttonHari5.setOnClickListener {
            if (isDayUnlocked(5)) {
                startWorkoutDay(5)
            } else {
                Toast.makeText(requireContext(), "Hari 5 terkunci, selesaikan Hari sebelumnya", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonHari6 = view.findViewById<Button>(R.id.buttonDay6)
        buttonHari6.setOnClickListener {
            if (isDayUnlocked(6)) {
                startWorkoutDay(6)
            } else {
                Toast.makeText(requireContext(), "Hari 6 terkunci, selesaikan Hari sebelumnya", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonHari7 = view.findViewById<Button>(R.id.buttonDay7)
        buttonHari7.setOnClickListener {
            if (isDayUnlocked(3)) {
                startWorkoutDay(3)
            } else {
                Toast.makeText(requireContext(), "Hari 7 terkunci, selesaikan Hari sebelumnya", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    // Function to apply scale-up animation
    private fun applyScaleAnimation(view: View) {
        val scaleAnimation = ScaleAnimation(
            1.0f, 1.1f, // From 100% to 110% on X-axis
            1.0f, 1.1f, // From 100% to 110% on Y-axis
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f
        )
        scaleAnimation.duration = 200 // 200ms for the scale animation
        scaleAnimation.fillAfter = true // Stay in the scaled state
        view.startAnimation(scaleAnimation)
    }

    // Function to apply scale-down animation
    private fun applyScaleDownAnimation(view: View) {
        val scaleDown = ScaleAnimation(
            1.1f, 1.0f, // From 110% to 100% on X-axis
            1.1f, 1.0f, // From 110% to 100% on Y-axis
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
            ScaleAnimation.RELATIVE_TO_SELF, 0.5f
        )
        scaleDown.duration = 200 // 200ms for the scale-down animation
        scaleDown.fillAfter = true // Keep the button at the original size
        view.startAnimation(scaleDown)
    }

    private fun startWorkoutDay(day: Int) {
        val intent = when (day) {
            1 -> Intent(requireContext(), ActivityTRAIN1::class.java)
            2 -> Intent(requireContext(), ActivityTRAIN2::class.java)
            3 -> Intent(requireContext(), ActivityTRAIN3::class.java)
            else -> null // Handle unexpected values
        }
        intent?.let { startActivity(it) }
    }

    // Function to check if the day is unlocked
    private fun isDayUnlocked(day: Int): Boolean {
        val sharedPreferences = requireActivity().getSharedPreferences("WorkoutProgress", AppCompatActivity.MODE_PRIVATE)
        val progress = sharedPreferences.getInt("PROGRESS_DAY", 0) // Ambil hari terakhir yang diselesaikan
        return day <= progress + 1 // Jika progress hari ke-n, unlock hari ke-(n+1)
    }

}