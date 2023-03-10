package com.ags.lcz.ui.group

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GroupViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is GroupViewModel Fragment"
    }
    val text: LiveData<String> = _text
}