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

class UsersAdapter(var userList: ArrayList<Users>) :
    RecyclerView.Adapter<UsersAdapter.UploadViewHolder>() {

    override fun getItemCount() = userList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_row_new_message, parent, false)

        return UploadViewHolder(view)
    }

    override fun onBindViewHolder(holder: UploadViewHolder, position: Int) {
        val users = userList[position]
        holder.textViewUsername?.text = users.Username
        //Picasso.get().load(users.ProfileImageUrl).into(holder.imageViewprofilepic)
    }


    class UploadViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var textViewUsername: TextView? = null
        var imageViewprofilepic: ImageView? = null

        init {
            this.textViewUsername = row.findViewById(R.id.textView_user)
            this.imageViewprofilepic = row.findViewById(R.id.imageView_user)
        }
    }
}