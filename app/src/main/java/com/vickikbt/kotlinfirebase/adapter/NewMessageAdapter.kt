package com.vickikbt.kotlinfirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.model.Users

class NewMessageAdapter(var usersList: ArrayList<Users>) :
    RecyclerView.Adapter<NewMessageViewHolder>() {

    override fun getItemCount() = usersList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_row_new_message, parent, false)

        return NewMessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewMessageViewHolder, position: Int) {
        val users = usersList[position]
        holder.textViewUsername?.text = "Vicki Kbt"
        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/kotlinfirebase-13e50.appspot.com/o/Profile%20Pictures%2F7b76a011-03d5-4a3d-ac49-06ae3812fc39?alt=media&token=121720ed-f196-416c-be5f-13f3e0241182")
            .into(holder.imageViewProfile)
    }

}

class NewMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var textViewUsername: TextView? = null
    var imageViewProfile: ImageView? = null

    init {
        this.textViewUsername = view.findViewById(R.id.textView_user)
        this.imageViewProfile = view.findViewById(R.id.imageView_user)
    }
}