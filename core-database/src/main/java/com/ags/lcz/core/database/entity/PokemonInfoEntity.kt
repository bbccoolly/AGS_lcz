package com.ags.lcz.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ags.lcz.core.model.PokemonInfo

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-03
 */
@Entity
data class PokemonInfoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<PokemonInfo.TypeResponse>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val exp: Int
)

