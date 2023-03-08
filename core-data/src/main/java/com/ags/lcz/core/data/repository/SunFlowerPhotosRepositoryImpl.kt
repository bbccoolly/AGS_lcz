package com.ags.lcz.core.data.repository

import androidx.annotation.WorkerThread
import com.ags.lcz.core.model.sunflower.SunflowerPhotosEntity
import com.ags.lcz.core.network.Dispatcher
import com.ags.lcz.core.network.LczAppDispatchers
import com.ags.lcz.core.network.service.SunflowerApiDexClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-08
 */
class SunFlowerPhotosRepositoryImpl @Inject constructor(
    private val sunflowerApiDexClient: SunflowerApiDexClient,
    @Dispatcher(LczAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher

) : SunFlowerPhotosRepository {

    @WorkerThread
    override fun fetchSunFlowerPhotosInfo(
        searchKey: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        var photosEntityList: List<SunflowerPhotosEntity>
        val response = sunflowerApiDexClient.fetchSunflowerPhotos(searchKey = searchKey)
        response.suspendOnSuccess {
            photosEntityList = data.results
            emit(photosEntityList)
        }.onFailure {
            onError(message())
        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)


}