package com.vickikbt.kotlinfirebase.adapter

import com.squareup.picasso.Picasso
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.model.Users
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.row_new_message.view.*

class NewMessageViewHolder(val user: Users) : Item<ViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.row_new_message
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textView_row_new_message.text = user.Username
        //Picasso.get().load(user.ProfileImageUrl).into(viewHolder.itemView.imageView_row_new_message)
    }
}