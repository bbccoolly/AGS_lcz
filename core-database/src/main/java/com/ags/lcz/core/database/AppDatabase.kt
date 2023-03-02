package com.ags.lcz.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ags.lcz.core.database.entity.PokemonEntity
import com.ags.lcz.core.database.entity.PokemonInfoEntity

/**
 *
 * desc: 用于保存数据库并作为应用持久性数据底层连接的主要访问点。
 *
 * create by lcz on 2023-03-02
 */
@Database(
    entities = [PokemonEntity::class, PokemonInfoEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(value = [TypeResponseConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonInfoDao(): PokemonInfoDao

}