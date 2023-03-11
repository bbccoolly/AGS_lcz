package com.ags.lcz.ui.home_square

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.skydoves.bindables.BindingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeSquareViewModel  @Inject constructor() : BindingViewModel() {
    private val _message = MutableLiveData<String>().apply {
        value = "This is 广场 Fragment"
    }

    val message: LiveData<String> = _message
}