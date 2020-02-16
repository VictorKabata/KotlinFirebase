package com.vickikbt.kotlinfirebase.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.adapter.UsersAdapter
import com.vickikbt.kotlinfirebase.databinding.ActivityNewMessageBinding
import com.vickikbt.kotlinfirebase.model.Users

class NewMessage : AppCompatActivity() {

    lateinit var binding: ActivityNewMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_message)
        supportActionBar?.title = "Select User"

        fetchUser()
    }

    private fun fetchUser() {
        val databaseRef = FirebaseDatabase.getInstance().getReference("/Users")

        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val users = ArrayList<Users>()
                val adapter = UsersAdapter(users)

                p0.children.forEach {
                    Log.e("New Message", it.toString())
                    val user = it.getValue(Users::class.java)
                    if (user != null) {
                        users.add(user)
                        binding.recyclerviewNewMessage.adapter = adapter
                    }
                }

            }

            override fun onCancelled(p0: DatabaseError) {
                //Do some shit here
            }
        })
    }
}


