package com.vickikbt.kotlinfirebase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.model.Users

class NewMessageAdapter(val users:ArrayList<Users>) :RecyclerView.Adapter<NewMessageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMessageViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.user_row_new_message, parent, false)
        return NewMessageViewHolder(view)
    }

    override fun getItemCount(): Int =users.size

    override fun onBindViewHolder(holder: NewMessageViewHolder, position: Int) {
        holder.textViewUsername.text=users[position].Username
    }

}

class NewMessageViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var textViewUsername:TextView=itemView.findViewById(R.id.textView_user)
}