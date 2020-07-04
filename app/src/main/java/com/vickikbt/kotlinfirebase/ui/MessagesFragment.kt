package com.vickikbt.kotlinfirebase.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.adapter.NewMessageAdapter
import com.vickikbt.kotlinfirebase.model.Users
import kotlinx.android.synthetic.main.fragment_messages.*

class MessagesFragment : Fragment() {
    //private lateinit var databaseRef: DatabaseReference
    val userList = ArrayList<Users>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)

        fetchUsers()

        return view
    }

    private fun fetchUsers() {
        val databaseRef = FirebaseDatabase.getInstance().getReference("/users")
        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val adapter = NewMessageAdapter(userList)

                dataSnapshot.children.forEach {
                    Log.e("VickiKbt", it.toString())
                    val user = it.getValue(Users::class.java)
                    userList.add(user!!)
                }
                recyclerView_users.adapter = adapter

            }

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(activity, "Unable to retrieve data!", Toast.LENGTH_LONG)
                    .show()
            }

        })
    }

}