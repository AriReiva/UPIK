package com.example.upik

import android.graphics.Bitmap
import android.graphics.BitmapFactory

data class UserProfile(
    val userId: Int,
    val username: String,
    val email: String,
    val password: String,
    val profileImage: ByteArray?
) {
    // Helper function to convert byte array to Bitmap, if needed in the UI
    fun getProfileImageBitmap(): Bitmap? {
        return profileImage?.let { BitmapFactory.decodeByteArray(it, 0, it.size) }
    }
}