package com.vickikbt.kotlinfirebase.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.databinding.ActivityRegisterBinding
import com.vickikbt.kotlinfirebase.model.Users
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val firebaseAuth = FirebaseAuth.getInstance()
    var selectedPhotoUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_register
        )

        binding.buttonSelectPhoto.setOnClickListener {
            selectPhoto()
        }

        binding.registerButton.setOnClickListener {
            registerUser()
        }

        binding.goToLoginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    //Uses bitmap to select user profile picture from the gallery
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            selectedPhotoUri = data.data
            val bitMap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)

            binding.selectPhotoImageView.setImageBitmap(bitMap)
            binding.buttonSelectPhoto.alpha = 0f
        }
    }

    //Uses bitmap to select user profile picture from the gallery
    private fun selectPhoto() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"

        startActivityForResult(intent, 0)
    }

    //Function to capture users data written in textview
    private fun registerUser() {
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEdiText.text.toString()

        when {
            username.isEmpty() -> Toast.makeText(this, "Enter Username!", Toast.LENGTH_SHORT).show()
            email.isEmpty() -> Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show()
            password.isEmpty() -> Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show()
            password.length < 8 -> Toast.makeText(this, "Password is too short!", Toast.LENGTH_SHORT).show()
        }

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                uploadImageToFirebase()

                if (!it.isSuccessful) return@addOnCompleteListener
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener {
                Log.e("Registration", "Failed to create user because: ${it.message}")
                Toast.makeText(this, "Failed to create user because: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    //Function to save user selected profile image to firebase storage
    private fun uploadImageToFirebase() {
        if (selectedPhotoUri == null) return

        val filename = UUID.randomUUID().toString()
        val storageRef = FirebaseStorage.getInstance().getReference("/Profile Pictures/$filename")
        storageRef.putFile(selectedPhotoUri!!)
            .addOnSuccessListener {
                Log.e("RegisterActivity", "Profile Picture Uploaded Successfully")

                storageRef.downloadUrl.addOnSuccessListener {
                        saveUserToFirebaseDatabase(it.toString())
                        Log.e("RegisterActivity", "Uploaded user data.")
                    }
                    .addOnFailureListener {
                        Log.e("RegisterActivity", "Failed to upload user data.")
                    }
            }


    }

    //Save both profile image and user detail to firebase database and firebase storage.
    private fun saveUserToFirebaseDatabase(profileImageUrl: String) {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val databaseRef = FirebaseDatabase.getInstance().getReference("/Users/$uid")

        val email = binding.emailEditText.text.toString()
        val username = binding.usernameEditText.text.toString()

        val users = Users(username, email, uid, profileImageUrl)

        databaseRef.setValue(users)
            .addOnSuccessListener {
                Log.e("Registration", "Saved user data to Firebase.")
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }

    }

}
