package com.vickikbt.kotlinfirebase.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_login
        )

        binding.goToRegisterTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.loginButton.setOnClickListener {
            loginUser()
        }
    }

    //Function to check email and password edittext and compare to data in firebase authentication.
    private fun loginUser() {
        val email = binding.emailAddressLogin.text.toString()
        val password = binding.passwordLogin.text.toString()

        when {
            email.isEmpty() -> Toast.makeText(
                this,
                "Enter Email Address!",
                Toast.LENGTH_SHORT
            ).show()
            password.isEmpty() -> Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show()
        }
        if (email.isEmpty() || password.isEmpty()) {
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
            .addOnFailureListener {
                Log.e("Login", "Failed to login user because: ${it.message}")
                Toast.makeText(this, "Failed to login user because: ${it.message}", Toast.LENGTH_LONG).show()
            }
    }

    //Function to check if the user has already signed in
    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
