package com.ags.lcz.core.data.di

import com.ags.lcz.core.data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-06
 */
@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsMainRepository(mainRepositoryImpl: PokemonRepositoryImpl): PokemonRepository

    @Binds
    fun bindsSunFlowerRepository(sunFlowerRepositoryImpl: SunFlowerRepositoryImpl): SunFlowerRepository

    @Binds
    fun bindPlayAndroidRepository(playAndroidRepositoryIml: PlayAndroidRepositoryIml): PlayAndroidRepository
}