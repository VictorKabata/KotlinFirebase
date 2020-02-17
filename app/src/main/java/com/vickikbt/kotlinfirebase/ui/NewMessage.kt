package com.vickikbt.kotlinfirebase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.*
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.adapter.NewMessageAdapter
import com.vickikbt.kotlinfirebase.databinding.ActivityNewMessageBinding
import com.vickikbt.kotlinfirebase.model.Users

class NewMessage : AppCompatActivity() {

    lateinit var binding: ActivityNewMessageBinding
    lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_message)
        supportActionBar?.title = "Select User"
        databaseRef = FirebaseDatabase.getInstance().getReference("Users")

        fetchUsers()
    }

    fun fetchUsers() {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val users = ArrayList<Users>()
                val adapter = NewMessageAdapter(users)
            }

            override fun onCancelled(p0: DatabaseError) {
                //Do some shit here
            }

        })
    }
}


