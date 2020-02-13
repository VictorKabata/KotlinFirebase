package com.vickikbt.kotlinfirebase.adapter

import com.vickikbt.kotlinfirebase.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class NewMessageViewHolder: Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.user_row_new_message
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        //Do some shit
    }
}