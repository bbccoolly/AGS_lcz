package com.ags.lcz.core.network.model

import com.ags.lcz.core.model.playandroid.HomeBannerEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
@JsonClass(generateAdapter = true)
data class PlayAndroidResponse(
    @field:Json(name = "data") val data: List<HomeBannerEntity>,
    @field:Json(name = "errorCode") val errorCode: Int,
    @field:Json(name = "errorMsg") val errorMsg: String?,
)
