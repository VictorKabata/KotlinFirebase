package com.vickikbt.kotlinfirebase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.adapter.NewMessageViewHolder
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_new_message.*

class NewMessage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        supportActionBar?.title = "Select User"
        val newMessageViewHolder = NewMessageViewHolder()
        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(newMessageViewHolder)
        adapter.add(newMessageViewHolder)
        adapter.add(newMessageViewHolder)
        recyclerview_new_message.adapter = adapter
    }
}


