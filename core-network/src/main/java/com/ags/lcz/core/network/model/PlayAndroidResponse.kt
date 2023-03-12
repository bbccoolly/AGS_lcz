package com.ags.lcz.core.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
@JsonClass(generateAdapter = true)
data class PlayAndroidResponse<T>(
    @field:Json(name = "data") val data: T,
    @field:Json(name = "errorCode") val errorCode: Int,
    @field:Json(name = "errorMsg") val errorMsg: String?,
)
