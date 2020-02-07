package com.vickikbt.kotlinfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vickikbt.kotlinfirebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.registerButton.setOnClickListener {
            registerUsers()
        }

        binding.goToLoginTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun registerUsers() {
        val username = binding.usernameEditText.text
        val email = binding.emailEditText.text
        val password = binding.passwordEdiText.text

        when {
            username!!.isEmpty() -> Toast.makeText(this, "Enter Username!", Toast.LENGTH_SHORT).show()
            email!!.isEmpty() -> Toast.makeText(this, "Enter Email!", Toast.LENGTH_SHORT).show()
            password!!.isEmpty() -> Toast.makeText(this, "Enter Password!", Toast.LENGTH_SHORT).show()
            password.length<=8 -> Toast.makeText(this, "Password is too short!", Toast.LENGTH_SHORT).show()

        }

    }
}
