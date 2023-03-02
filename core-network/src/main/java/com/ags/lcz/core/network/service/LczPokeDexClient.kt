package com.ags.lcz.core.network.service

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import com.ags.lcz.core.model.PokemonInfo
import com.ags.lcz.core.network.model.PokemonResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-03
 */
class LczPokeDexClient @Inject constructor(private val lczApiService: LczApiService) {
    suspend fun fetchPokemonList(page: Int): ApiResponse<PokemonResponse> =
        lczApiService.fetchPokemonList(limit = PAGE_SIZE, offset = page * PAGING_SIZE)

    suspend fun fetchPokemonInfo(name: String): ApiResponse<PokemonInfo> =
        lczApiService.fetchPokemonInfo(name = name)

    companion object {
        private const val PAGING_SIZE = 20
    }
}