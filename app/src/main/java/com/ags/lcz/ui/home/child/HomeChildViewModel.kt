package com.ags.lcz.ui.home.child

import androidx.annotation.MainThread
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ags.lcz.core.data.repository.PlayAndroidRepository
import com.ags.lcz.core.model.playandroid.ArticleDetailEntity
import com.ags.lcz.core.model.playandroid.HomeArticleEntity
import com.ags.lcz.core.model.playandroid.HomeBannerEntity
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeChildViewModel @Inject constructor(
    private val playAndroidRepository: PlayAndroidRepository
) : BindingViewModel() {

    private val _message = MutableLiveData<String>().apply {
        value = "This is 首页 Fragment"
    }

    val message: LiveData<String> = _message

    private val _bannerInfo = MutableLiveData<List<HomeBannerEntity>>()
    val bannerInfo: LiveData<List<HomeBannerEntity>> = _bannerInfo

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val articleFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val homeArticleListFlow = articleFetchingIndex.flatMapLatest { page ->
        playAndroidRepository.getHomeArticleList(
            page,
            10,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { toastMessage = it }
        )
    }

    @get:Bindable
    val homeArticleList: HomeArticleEntity by homeArticleListFlow.asBindingProperty(
        viewModelScope, HomeArticleEntity()
    )

    @MainThread
    fun fetchNextArticleList() {
        if (!isLoading) {
//            articleFetchingIndex.value++
        }
    }

//    private val bannerInfoListFlow =
//        playAndroidRepository.getHomeBannerInfo(
//            onStart = { isLoading = true },
//            onComplete = { isLoading = false },
//            onError = { toastMessage = it }
//        )


//    @get:Bindable
//    val bannerInfoList: List<HomeBannerEntity> by bannerInfoListFlow.asBindingProperty(
//        viewModelScope, emptyList()
//    )

    init {
        viewModelScope.launch {
            playAndroidRepository.getHomeBannerInfo(
                onStart = { isLoading = true },
                onComplete = { isLoading = false },
                onError = { toastMessage = it }
            ).collect {
                _bannerInfo.value = it
            }
        }
    }

}