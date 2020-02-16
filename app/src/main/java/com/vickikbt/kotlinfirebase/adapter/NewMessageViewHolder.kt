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
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.user_row_new_message.view.*

class UsersAdapter(var uploadList: ArrayList<Users>) :
    RecyclerView.Adapter<UsersAdapter.UploadViewHolder>() {

    override fun getItemCount() = uploadList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)

        return UploadViewHolder(view)
    }

    override fun onBindViewHolder(holder: UploadViewHolder, position: Int) {
        val uploads = uploadList[position]
        holder.textViewUsername?.text = uploads.username
        holder.textViewCategory?.text = uploads.category
        holder.textViewDescription?.text = uploads.description
        Picasso.get().load(uploads.profilePicUrl).into(holder.imageViewprofilepic)
        Picasso.get().load(uploads.photourl).into(holder.imageViewphoto)
    }


    class UploadViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var textViewUsername: TextView? = null
        var textViewCategory: TextView? = null
        var textViewDescription: TextView? = null
        var imageViewphoto: ImageView? = null
        var imageViewprofilepic: ImageView? = null

        init {
            this.textViewUsername = row.findViewById(R.id.recyclerView_username)
            this.textViewCategory = row.findViewById(R.id.recyclerView_category)
            this.textViewDescription = row.findViewById(R.id.recyclerView_description)
            this.imageViewphoto = row.findViewById(R.id.recyclerView_photo)
            this.imageViewprofilepic = row.findViewById(R.id.recyclerView_profilePic)
        }
    }
}