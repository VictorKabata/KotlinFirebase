package com.vickikbt.kotlinfirebase.ui.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vickikbt.kotlinfirebase.R

class ProfileFragment : Fragment() {

    lateinit var profileViewModel: ProfileFragmentVieModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel=ViewModelProvider(this).get(ProfileFragmentVieModel::class.java)
        val root= inflater.inflate(R.layout.fragment_profile, container, false)

        val textView: TextView = root.findViewById(R.id.text_profile)
        profileViewModel.text.observe(this, Observer {
            textView.text = it
        })

        return root
    }


}
