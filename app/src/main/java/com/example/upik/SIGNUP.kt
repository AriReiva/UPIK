package com.example.upik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.SharedPreferences
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.graphics.Bitmap
import android.provider.MediaStore
import java.io.ByteArrayOutputStream
import android.net.Uri
import android.graphics.BitmapFactory
import java.io.InputStream

class SIGNUP : AppCompatActivity() {
    private lateinit var db: DATABASE
    private lateinit var sharedPreferences: SharedPreferences
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_IMAGE_GALLERY = 2
    private lateinit var selectedImage: Bitmap
    private lateinit var profileImageView: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        db = DATABASE(this)

        val usernameEditText = findViewById<EditText>(R.id.userSIGN)
        val emailEditText = findViewById<EditText>(R.id.emailSIGN)
        val passwordEditText = findViewById<EditText>(R.id.passSIGN)
        val signUpButton = findViewById<Button>(R.id.SIGNUP_BUTTON)
        profileImageView = findViewById(R.id.selectedimage)

        profileImageView.setOnClickListener {
            openImageOptions()// Capture image from camera
        }

        signUpButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && ::selectedImage.isInitialized) {
                val success = db.insertUser(username, email, password, selectedImage)

                if (success) {
                    Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Sign-up failed.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Please fill all fields and add a profile image",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
    }
    private fun openImageOptions() {
        // Membuat pilihan antara kamera dan galeri
        val options = arrayOf("Take Picture", "Choose from Gallery")
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Select Image")
        builder.setItems(options) { dialog, which ->
            when (which) {
                0 -> dispatchTakePictureIntent() // Buka kamera
                1 -> openGalleryIntent()         // Buka galeri
            }
        }
        builder.show()
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    private fun openGalleryIntent() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    val imageBitmap = data?.extras?.get("data") as Bitmap
                    selectedImage = imageBitmap
                    profileImageView.setImageBitmap(selectedImage) // Tampilkan gambar hasil foto di ImageView
                }
                REQUEST_IMAGE_GALLERY -> {
                    val imageUri: Uri? = data?.data
                    imageUri?.let {
                        val imageStream: InputStream? = contentResolver.openInputStream(it)
                        selectedImage = BitmapFactory.decodeStream(imageStream)
                        profileImageView.setImageBitmap(selectedImage) // Tampilkan gambar yang dipilih dari galeri di ImageView
                    }
                }
            }
        }
    }
}