package com.ags.lcz.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-03
 */
@Entity
data class PokemonEntity(
    var page: Int = 0,
    @PrimaryKey val name: String,
    val url: String
)
