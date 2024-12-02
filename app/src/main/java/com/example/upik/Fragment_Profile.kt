package com.example.upik

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.content.Context

class Fragment_Profile : Fragment() {

    private lateinit var db: DATABASE
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var profileImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment__profile, container, false)

        db = DATABASE(requireContext())
        sharedPreferences = requireActivity().getSharedPreferences("userSession", Context.MODE_PRIVATE)

        // Inisialisasi Views
        usernameTextView = view.findViewById(R.id.usernameTextViewProfile)
        emailTextView = view.findViewById(R.id.emailTextViewProfile)
        profileImageView = view.findViewById(R.id.profileImageView)

        // Ambil userId dari SharedPreferences
        val userId = sharedPreferences.getInt("userId", -1)
        if (userId != -1) {
            val user = db.getUserById(userId)
            if (user != null) {
                // Tampilkan data ke Views
                usernameTextView.text = user.username
                emailTextView.text = user.email

                val profileBitmap = user.profileImage?.let { db.byteArrayToBitmap(it) }
                profileBitmap?.let {
                    profileImageView.setImageBitmap(it)
                }
            }
        }

        return view
    }
}