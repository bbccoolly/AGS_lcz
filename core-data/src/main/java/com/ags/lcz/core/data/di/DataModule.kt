package com.ags.lcz.core.data.di

import com.ags.lcz.core.data.repository.MainRepository
import com.ags.lcz.core.data.repository.MainRepositoryImpl
import com.ags.lcz.core.data.repository.SunFlowerPhotosRepository
import com.ags.lcz.core.data.repository.SunFlowerPhotosRepositoryImpl
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
    fun bindsMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

    @Binds
    fun bindsSunFlowerRepository(sunFlowerPhotosRepositoryImpl: SunFlowerPhotosRepositoryImpl): SunFlowerPhotosRepository
}