package com.ags.lcz.ui.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProjectViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is ProjectViewModel Fragment"
    }
    val text: LiveData<String> = _text
}