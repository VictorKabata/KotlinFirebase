package com.vickikbt.kotlinfirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.vickikbt.kotlinfirebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    private val firebaseAuth=FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.registerButton.setOnClickListener {
            registerUser()
        }

        binding.goToLoginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun registerUser(){
        val username = binding.usernameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEdiText.text.toString()

        when {
            username.isEmpty() -> Toast.makeText(this, "Enter Username!", Toast.LENGTH_SHORT).show()
            email.isEmpty() -> Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show()
            password.isEmpty() -> Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show()
            password.length<8 -> Toast.makeText(this, "Password is too short!", Toast.LENGTH_SHORT).show()
        }

        if (username.isEmpty()||email.isEmpty()||password.isEmpty()){
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(!it.isSuccessful) return@addOnCompleteListener
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                Log.e("Registration", "Failed to create user because: ${it.message}")
                Toast.makeText(this, "Failed to create user because: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

}
