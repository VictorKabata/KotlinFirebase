package com.vickikbt.kotlinfirebase.ui.messages

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.vickikbt.kotlinfirebase.ui.NewMessage
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.ui.LoginActivity

class MessagesFragment : Fragment() {

    private lateinit var dashboardViewModel: MessagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(MessagesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_messages, container, false)

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.messages_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_new_message->{
                startActivity(Intent(activity, NewMessage::class.java))
            }

            R.id.action_logout_messages->{
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(activity, LoginActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}