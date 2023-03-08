package com.ags.lcz.core.model.sunflower

import com.google.gson.annotations.SerializedName


/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-08
 */
data class SunflowerPhotosEntity(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("urls") val urls: UnsplashPhotoUrls,
    @field:SerializedName("user") val user: UnsplashUser
)

data class UnsplashPhotoUrls(
    @field:SerializedName("small") val small: String
)

data class UnsplashUser(
    @field:SerializedName("name") val name: String,
    @field:SerializedName("username") val username: String
) {
    val attributionUrl: String
        get() {
            return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
        }
}
