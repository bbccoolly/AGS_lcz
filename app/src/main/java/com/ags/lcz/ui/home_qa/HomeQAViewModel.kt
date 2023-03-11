package com.ags.lcz.ui.home_qa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.skydoves.bindables.BindingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeQAViewModel @Inject constructor()  : BindingViewModel() {
    private val _message = MutableLiveData<String>().apply {
        value = "This is 问答 Fragment"
    }

    val message: LiveData<String> = _message

}