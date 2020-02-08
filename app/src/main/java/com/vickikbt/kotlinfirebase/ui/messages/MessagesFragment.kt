package com.vickikbt.kotlinfirebase.ui.messages

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.vickikbt.kotlinfirebase.ui.NewMessage
import com.vickikbt.kotlinfirebase.R
import com.vickikbt.kotlinfirebase.databinding.FragmentMessagesBinding
import com.vickikbt.kotlinfirebase.ui.LoginActivity

class MessagesFragment : Fragment() {

    private lateinit var dashboardViewModel: MessagesViewModel
    private lateinit var binding:FragmentMessagesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(MessagesViewModel::class.java)
        binding =DataBindingUtil.inflate( inflater, R.layout.fragment_messages, container, false)

        binding.fabNewMessage.setOnClickListener{
            val intent=Intent(activity, NewMessage::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}