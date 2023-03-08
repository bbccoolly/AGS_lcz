package com.ags.lcz.core.data.repository

import androidx.annotation.WorkerThread
import com.ags.lcz.core.model.sunflower.SunflowerPhotosEntity
import kotlinx.coroutines.flow.Flow

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-08
 */
interface SunFlowerPhotosRepository {

    @WorkerThread
    fun fetchSunFlowerPhotosInfo(
        searchKey: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<SunflowerPhotosEntity>>
}