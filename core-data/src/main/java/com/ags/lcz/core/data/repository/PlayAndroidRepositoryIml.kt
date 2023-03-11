package com.ags.lcz.core.data.repository

import com.ags.lcz.core.network.Dispatcher
import com.ags.lcz.core.network.LczAppDispatchers
import com.ags.lcz.core.network.service.PlayAndroidDexClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import timber.log.Timber
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
class PlayAndroidRepositoryIml @Inject constructor(
    private val playAndroidDexClient: PlayAndroidDexClient,
    @Dispatcher(LczAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : PlayAndroidRepository {
    override fun getHomeBannerInfo(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        val response = playAndroidDexClient.getHomeBannerInfo()
        response.suspendOnSuccess {
            emit(data.data)
        }.onFailure {
            onError { message() }
        }
    }.onStart { onStart() }.onCompletion { onComplete }.flowOn(ioDispatcher)
}