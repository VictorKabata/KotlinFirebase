package com.vickikbt.kotlinfirebase.adapter

import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.model.Users
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.user_row_new_message.view.*

class NewMessageViewHolder(val users: Users) : Item<ViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.user_row_new_message
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textView_user.text = users.Username
        //Picasso.get().load(users.ProfileImageUrl).into(viewHolder.itemView.imageView_user)
    }
}