package com.ags.lcz.ui

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ags.lcz.core.data.repository.MainRepository
import com.ags.lcz.core.data.repository.SunFlowerPhotosRepository
import com.ags.lcz.core.model.Pokemon
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-06
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val sunFlowerPhotosRepository: SunFlowerPhotosRepository
) : BindingViewModel() {

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val sunflowerFetchSearchKey: MutableStateFlow<Int> = MutableStateFlow(0)
    private val sunflowerListFlow = sunflowerFetchSearchKey.flatMapLatest {
        sunFlowerPhotosRepository.fetchSunFlowerPhotosInfo(
            searchKey = "风景",
            onStart = { toastMessage = "1" },
            onComplete = { toastMessage = "2" },
            onError = { toastMessage = "3" }
        )
    }

    private val pokemonFetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val pokemonListFlow = pokemonFetchingIndex.flatMapLatest { page ->
        mainRepository.fetchPokemonList(
            page = page,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { toastMessage = it }
        )
    }

    @get:Bindable
    val pokemonList: List<Pokemon> by pokemonListFlow.asBindingProperty(viewModelScope, emptyList())

    init {
        Timber.d("init MainViewModel")
    }

    @MainThread
    fun fetchNextPokemonList() {
        if (!isLoading) {
            pokemonFetchingIndex.value++
        }
    }

    @MainThread
    fun fetchNextPhotoList() {
        sunflowerFetchSearchKey.value = 1
    }

}