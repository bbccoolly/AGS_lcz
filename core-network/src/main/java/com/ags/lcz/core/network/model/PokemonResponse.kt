package com.ags.lcz.core.network.model

import com.ags.lcz.core.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-02
 */
@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @field:Json(name = "count") val count: Int,
    @field:Json(name = "next") val next: String?,
    @field:Json(name = "previous") val previous: String?,
    @field:Json(name = "results") val results: List<Pokemon>
)
