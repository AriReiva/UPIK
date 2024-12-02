package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HOMEPAGE : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Inisialisasi BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Mengatur navigasi ke fragment sesuai dengan menu yang diklik
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_training -> {
                    // Navigasi ke HomeFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentTrain())
                        .commit()
                    true
                }
                R.id.nav_home -> {
                    // Navigasi ke HomeFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Fragment_home())
                        .commit()
                    true
                }
                R.id.nav_resep -> {
                    // Navigasi ke ProfileFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentResepMakanan())
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    // Navigasi ke ProfileFragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Fragment_Profile())
                        .commit()
                    true
                }
                R.id.nav_berita -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentCoin())
                        .commit()
                    true
                }
                else -> false
            }
        }

        // Memastikan HomeFragment ditampilkan saat pertama kali aplikasi dibuka
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.nav_home
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment_home())
                .commit()
        }
    }
}