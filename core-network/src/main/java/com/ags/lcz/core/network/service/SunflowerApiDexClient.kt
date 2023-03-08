package com.ags.lcz.core.network.service

import com.ags.lcz.core.network.model.SunflowerResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-08
 */
class SunflowerApiDexClient @Inject constructor(
    private val sunflowerApiService: SunflowerApiService
) {
    suspend fun fetchSunflowerPhotos(
        searchKey: String
    ): ApiResponse<SunflowerResponse> =
        sunflowerApiService.searchPhotos(searchKey, PAGING_SIZE, PAGING_PER)

    companion object {
        private const val PAGING_SIZE = 1
        private const val PAGING_PER = 5
    }
}