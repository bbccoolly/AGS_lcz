package com.ags.lcz.ui.home

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ags.lcz.core.data.repository.PlayAndroidRepository
import com.ags.lcz.core.model.playandroid.HomeBannerEntity
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val playAndroidRepository: PlayAndroidRepository
) : BindingViewModel() {

    private val _bannerInfo = MutableLiveData<List<HomeBannerEntity>>()
    val bannerInfo: LiveData<List<HomeBannerEntity>> = _bannerInfo

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

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
            ).collect{
                _bannerInfo.value = it
            }
        }
    }

}