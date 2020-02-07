package com.vickikbt.kotlinfirebase.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileFragmentVieModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"
    }
    val text: LiveData<String> = _text

}