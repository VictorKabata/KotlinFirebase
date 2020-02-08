package com.vickikbt.kotlinfirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vickikbt.kotlinfirebase.R

class NewMessage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)
        supportActionBar?.title="Select User"
    }
}
