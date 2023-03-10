package com.ags.lcz.ui.mine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MineViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is MineViewModel Fragment"
    }
    val text: LiveData<String> = _text
}