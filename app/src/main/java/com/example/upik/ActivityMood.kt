package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ActivityMood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)

        val back = findViewById<ImageView>(R.id.backimageMood)
        val dropdownLayout = findViewById<LinearLayout>(R.id.dropdownLayout)
        val superGoodMood = findViewById<ImageView>(R.id.verygood)
        val goodMood = findViewById<ImageView>(R.id.good)
        val neutralMood = findViewById<ImageView>(R.id.meh)
        val badMood = findViewById<ImageView>(R.id.bad)
        val awfulMood = findViewById<ImageView>(R.id.awful)
        val tips1 = findViewById<TextView>(R.id.tips1)
        val tips2 = findViewById<TextView>(R.id.tips2)
        val tips3 = findViewById<TextView>(R.id.tips3)
        val tips4 = findViewById<TextView>(R.id.tips4)
        val tips5 = findViewById<TextView>(R.id.tips5)
        val tips6 = findViewById<TextView>(R.id.tips6)

        back.setOnClickListener {
            finish()
        }

        superGoodMood.setOnClickListener {
            applyScaleAnimation(superGoodMood)

            superGoodMood.postDelayed({
                applyScaleDownAnimation(superGoodMood)
            }, 200)

            // Toggle dropdown visibility
            toggleDropdown(dropdownLayout)

            // Show tips for bad mood
            showTipsForMood("super good", tips1, tips2, tips3, tips4, tips5, tips6)
        }

        goodMood.setOnClickListener {
            applyScaleAnimation(goodMood)

            goodMood.postDelayed({
                applyScaleDownAnimation(goodMood)
            }, 200)

            // Toggle dropdown visibility
            toggleDropdown(dropdownLayout)

            // Show tips for bad mood
            showTipsForMood("good", tips1, tips2, tips3, tips4, tips5, tips6)
        }

        neutralMood.setOnClickListener {
            applyScaleAnimation(neutralMood)

            neutralMood.postDelayed({
                applyScaleDownAnimation(neutralMood)
            }, 200)

            // Toggle dropdown visibility
            toggleDropdown(dropdownLayout)

            // Show tips for bad mood
            showTipsForMood("neutral", tips1, tips2, tips3, tips4, tips5, tips6)
        }

        badMood.setOnClickListener {
            applyScaleAnimation(badMood)

            badMood.postDelayed({
                applyScaleDownAnimation(badMood)
            }, 200)

            // Toggle dropdown visibility
            toggleDropdown(dropdownLayout)

            // Show tips for bad mood
            showTipsForMood("bad", tips1, tips2, tips3, tips4, tips5, tips6)
        }

        awfulMood.setOnClickListener {
            applyScaleAnimation(awfulMood)

            awfulMood.postDelayed({
                applyScaleDownAnimation(awfulMood)
            }, 200)

            // Toggle dropdown visibility
            toggleDropdown(dropdownLayout)

            // Show tips for bad mood
            showTipsForMood("awful", tips1, tips2, tips3, tips4, tips5, tips6)
        }
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

    private fun toggleDropdown(dropdownLayout: LinearLayout) {
        if (dropdownLayout.visibility == View.GONE) {
            dropdownLayout.visibility = View.VISIBLE
        } else {
            dropdownLayout.visibility = View.GONE
        }
    }

    // Function to show tips based on mood, now with 6 specific suggestions per mood
    private fun showTipsForMood(mood: String, tips1: TextView, tips2: TextView, tips3: TextView, tips4: TextView, tips5: TextView, tips6: TextView) {
        when (mood) {
            "super good" -> {
                tips1.text = "Keep doing what you're doing!"
                tips2.text = "Continue spreading positivity."
                tips3.text = "Reward yourself with something fun."
                tips4.text = "Get some fresh air or take a walk."
                tips5.text = "Drink plenty of water to stay refreshed."
                tips6.text = "Share your success with friends!"
            }
            "good" -> {
                tips1.text = "You're doing well, maintain it!"
                tips2.text = "Try a light workout or stretch."
                tips3.text = "Enjoy a healthy snack or fruit."
                tips4.text = "Take a short break to recharge."
                tips5.text = "Read something inspiring."
                tips6.text = "Take time to appreciate the small wins."
            }
            "neutral" -> {
                tips1.text = "Take a deep breath and relax."
                tips2.text = "Listen to some calming music."
                tips3.text = "Go for a short walk outside."
                tips4.text = "Take a 5-minute break from screens."
                tips5.text = "Try journaling your thoughts."
                tips6.text = "Make a list of things you're grateful for."
            }
            "bad" -> {
                tips1.text = "It's okay to take it easy."
                tips2.text = "Take a short nap to recharge."
                tips3.text = "Talk to a friend or family member."
                tips4.text = "Do something that makes you smile."
                tips5.text = "Take deep breaths to calm your mind."
                tips6.text = "Do a quick 5-minute stretch or yoga."
            }
            "very bad" -> {
                tips1.text = "Take time for yourself."
                tips2.text = "Have some water and rest."
                tips3.text = "Consider a change of scenery."
                tips4.text = "Disconnect from social media for a while."
                tips5.text = "Write down how you're feeling."
                tips6.text = "Reach out to someone for support."
            }
            "awful" -> {
                tips1.text = "It’s okay to feel down sometimes."
                tips2.text = "Take slow, deep breaths to relax."
                tips3.text = "Try talking to someone you trust."
                tips4.text = "Consider watching or reading something uplifting."
                tips5.text = "Don't hesitate to ask for professional help."
                tips6.text = "Focus on doing one small task at a time."
            }
        }
    }

}