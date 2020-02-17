package com.vickikbt.kotlinfirebase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.databinding.ActivityNewMessageBinding

class NewMessage : AppCompatActivity() {

    lateinit var binding: ActivityNewMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_message)
        supportActionBar?.title = "Select User"

        fetchUser()
    }

    fun fetchUsers() {

    }
}


