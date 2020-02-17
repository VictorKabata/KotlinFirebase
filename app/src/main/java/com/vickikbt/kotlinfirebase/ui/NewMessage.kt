package com.vickikbt.kotlinfirebase.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.*
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.adapter.NewMessageAdapter
import com.vickikbt.kotlinfirebase.databinding.ActivityNewMessageBinding
import com.vickikbt.kotlinfirebase.model.Users
import kotlinx.android.synthetic.main.activity_new_message.*

class NewMessage : AppCompatActivity() {

    lateinit var binding: ActivityNewMessageBinding
    lateinit var databaseRef: DatabaseReference
    var usersList: ArrayList<Users>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_message)
        supportActionBar?.title = "Select User"
        databaseRef = FirebaseDatabase.getInstance().getReference("Users")
        usersList = ArrayList<Users>()

        fetchUsers()
    }

    private fun fetchUsers() {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val users = ArrayList<Users>()
                val adapter = NewMessageAdapter(users)

                p0.children.forEach {
                    Log.e("New Message", it.toString())
                    val user = it.getValue(Users::class.java)
                    if (user != null) {
                        users.add(user)
                        recyclerView_users.adapter = adapter
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(applicationContext, "Unable to retrieve data!", Toast.LENGTH_LONG).show()
            }

        })
    }
}


