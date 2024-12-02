package com.example.upik

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class Fragment_home : Fragment() {

    private lateinit var db: DATABASE
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        db = DATABASE(requireContext())
        sharedPreferences = requireActivity().getSharedPreferences("userSession", Context.MODE_PRIVATE)

        val usernameTextView = view.findViewById<TextView>(R.id.hello_user_text)
        val userId = sharedPreferences.getInt("userId", -1)
        if (userId != -1) {
            val user = db.getUserById(userId)
            if (user != null) {
                // Tampilkan data ke Views
                val username = user.username
                usernameTextView.text = "Hello $username;"
            }
        }

        val buttonResep = view.findViewById<CardView>(R.id.resep_hom_card)
        buttonResep.setOnClickListener {
            val fragment = FragmentResepMakanan()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack so the user can navigate back
            transaction.commit()
        }

        val buttonTrain = view.findViewById<CardView>(R.id.train_home_card)
        buttonTrain.setOnClickListener {
            val fragment = FragmentTrain()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack so the user can navigate back
            transaction.commit()
        }

        val buttonMood = view.findViewById<CardView>(R.id.emosi_home_card)
        buttonMood.setOnClickListener {
            val intent = Intent(requireActivity(),ActivityMood::class.java)
            startActivity(intent)
        }

        val buttonWater = view.findViewById<CardView>(R.id.water_home_card)
        buttonWater.setOnClickListener {
            val intent = Intent(requireActivity(),ActivityWaterReminerDay7::class.java)
            startActivity(intent)
        }

        return view
    }
}