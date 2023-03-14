package com.ags.lcz.core.data.repository

import androidx.annotation.WorkerThread
import com.ags.lcz.core.model.playandroid.ArticleDetailEntity
import com.ags.lcz.core.model.playandroid.HomeArticleEntity
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

    @WorkerThread
    fun getHomeArticleList(
        pageNo: Int,
        pageSize: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<HomeArticleEntity>

    @WorkerThread
    fun getHomeArticleTopList(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<HomeArticleEntity>

    @WorkerThread
    fun getHomeSquarePageList(
        pageNo: Int,
        pageSize: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<HomeArticleEntity>

    @WorkerThread
    fun getHomeAnswerPageList(
        pageNo: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<HomeArticleEntity>
}