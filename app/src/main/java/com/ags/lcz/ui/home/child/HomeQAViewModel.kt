package com.ags.lcz.ui.home.child

import androidx.annotation.MainThread
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ags.lcz.core.data.repository.PlayAndroidRepository
import com.ags.lcz.core.model.playandroid.HomeArticleEntity
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class HomeQAViewModel @Inject constructor(
    private val playAndroidRepository: PlayAndroidRepository
) : BindingViewModel() {
    private val _message = MutableLiveData<String>().apply {
        value = "This is 问答 Fragment"
    }
    val message: LiveData<String> = _message


    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val articleFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val hqArticleListFlow = articleFetchingIndex.flatMapLatest { page ->
        playAndroidRepository.getHomeAnswerPageList(
            page,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { toastMessage = it }
        )
    }

    @get:Bindable
    val hqArticleList: HomeArticleEntity by hqArticleListFlow.asBindingProperty(
        viewModelScope, HomeArticleEntity()
    )

    @MainThread
    fun fetchNextAnswerArticleList() {
        if (!isLoading) {
            articleFetchingIndex.value++
        }
    }
}