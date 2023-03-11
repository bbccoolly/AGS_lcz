package com.ags.lcz.core.network.service

import com.ags.lcz.core.network.model.PlayAndroidResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

/**
 *
 * desc: https://www.wanandroid.com/blog/show/2 玩安卓接口文件
 *
 * create by lcz on 2023-03-11
 */
interface PlayAndroidApiService {

    @GET("banner/json")
    suspend fun getHomeBannerInfo(): ApiResponse<PlayAndroidResponse>


}