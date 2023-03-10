package com.ags.lcz.ui.home

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BindingViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is HomeViewModel Fragment"
    }
    val text: LiveData<String> = _text

    @get:Bindable
    var textMessage: String? by bindingProperty("HomeViewModel")
}