package com.ags.lcz.core.model.playandroid

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class HomeBannerEntity(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
) : Parcelable