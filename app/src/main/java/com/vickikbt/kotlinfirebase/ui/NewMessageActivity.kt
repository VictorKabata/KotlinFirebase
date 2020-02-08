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
import com.vickikbt.kotlinfirebase.adapter.NewMessageViewHolder
import com.vickikbt.kotlinfirebase.databinding.ActivityNewMessageBinding
import com.vickikbt.kotlinfirebase.model.Users
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class NewMessageActivity : AppCompatActivity() {
    lateinit var binding:ActivityNewMessageBinding

    private val users=Users()
    val userItem = NewMessageViewHolder(users)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_new_message)
        supportActionBar?.title = "Select User"

        fetchUsers()
    }

    private fun fetchUsers() { //Fetch all users in the database
        val databaseRef = FirebaseDatabase.getInstance().getReference("/Users")

        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val rvAdapter = GroupAdapter<ViewHolder>()

                p0.children.forEach {
                    Log.e("New Message", it.toString())
                    val user = it.getValue(Users::class.java)
                    if (user != null) {
                        rvAdapter.add(userItem)
                    }
                }
                binding.recyclerviewNewMessage.adapter = rvAdapter
            }

            override fun onCancelled(p0: DatabaseError) {
            }
        })


    }
}
