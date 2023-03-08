package com.ags.lcz.core.network.model

import com.ags.lcz.core.model.sunflower.SunflowerPhotosEntity
import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-08
 */
data class SunflowerResponse(
    @field:SerializedName("results") val results: List<SunflowerPhotosEntity>,
    @field:SerializedName("total_pages") val totalPages: Int
)
