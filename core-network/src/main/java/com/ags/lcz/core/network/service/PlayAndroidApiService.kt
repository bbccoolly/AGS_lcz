package com.ags.lcz.core.network.service

import com.ags.lcz.core.model.playandroid.HomeBannerEntity
import com.ags.lcz.core.model.playandroid.HomeArticleEntity
import com.ags.lcz.core.network.model.PlayAndroidResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * desc: https://www.wanandroid.com/blog/show/2 玩安卓接口文件
 *
 * create by lcz on 2023-03-11
 */
interface PlayAndroidApiService {


    // home banner
    @GET("banner/json")
    suspend fun getHomeBannerInfo(): ApiResponse<PlayAndroidResponse<List<HomeBannerEntity>>>

    // 首页文章列表
    @GET("article/list/{pageNo}/json")
    suspend fun getHomeArticleInfo(
        @Path("pageNo") pageNo: Int,
        @Query("page_size") pageSize: Int
    ): ApiResponse<PlayAndroidResponse<HomeArticleEntity>>

}