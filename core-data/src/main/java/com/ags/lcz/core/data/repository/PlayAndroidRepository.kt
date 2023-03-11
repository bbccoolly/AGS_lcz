package com.ags.lcz.core.data.repository

import androidx.annotation.WorkerThread
import com.ags.lcz.core.model.playandroid.HomeBannerEntity
import kotlinx.coroutines.flow.Flow

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-06
 */
interface PlayAndroidRepository {
    @WorkerThread
    fun getHomeBannerInfo(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<HomeBannerEntity>>
}