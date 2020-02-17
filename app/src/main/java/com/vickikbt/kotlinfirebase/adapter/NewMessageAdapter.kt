package com.vickikbt.kotlinfirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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