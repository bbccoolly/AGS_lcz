package com.ags.lcz.ui.navigator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigatorViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is NavigatorViewModel Fragment"
    }
    val text: LiveData<String> = _text
}