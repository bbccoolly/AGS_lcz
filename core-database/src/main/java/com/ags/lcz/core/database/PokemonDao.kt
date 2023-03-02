package com.ags.lcz.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ags.lcz.core.database.entity.PokemonEntity

/**
 *
 * desc: 提供您的应用可用于查询、更新、插入和删除数据库中的数据的方法。
 *
 * create by lcz on 2023-03-02
 */
@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<PokemonEntity>)

    @Query("SELECT * FROM PokemonEntity WHERE page = :page_")
    suspend fun getPokemonList(page_: Int): List<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE page <= :page_")
    suspend fun getAllPokemonList(page_: Int): List<PokemonEntity>
}
