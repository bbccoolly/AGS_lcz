package com.ags.lcz.core.network.service

import com.ags.lcz.core.model.playandroid.HomeBannerEntity
import com.ags.lcz.core.model.playandroid.HomeArticleEntity
import com.ags.lcz.core.network.model.PlayAndroidResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
class PlayAndroidDexClient @Inject constructor(
    private val playAndroidApiService: PlayAndroidApiService
) {
    suspend fun getHomeBannerInfo(): ApiResponse<PlayAndroidResponse<List<HomeBannerEntity>>> =
        playAndroidApiService.getHomeBannerInfo()

    suspend fun getHomeArticlePageList(
        pageNo: Int,
        pageSize: Int
    ): ApiResponse<PlayAndroidResponse<HomeArticleEntity>> =
        playAndroidApiService.getHomeArticlePageList(pageNo = pageNo, pageSize = pageSize)

    suspend fun getHomeArticleTopList(): ApiResponse<PlayAndroidResponse<HomeArticleEntity>> =
        playAndroidApiService.getHomeArticleTopList()

    suspend fun getHomeSquarePageList(
        pageNo: Int,
        pageSize: Int
    ): ApiResponse<PlayAndroidResponse<HomeArticleEntity>> =
        playAndroidApiService.getHomeSquarePageList(pageNo = pageNo, pageSize = pageSize)

    suspend fun getHomeAnswerPageList(
        pageNo: Int
    ): ApiResponse<PlayAndroidResponse<HomeArticleEntity>> =
        playAndroidApiService.getHomeAnswerPageList(pageNo = pageNo)
}