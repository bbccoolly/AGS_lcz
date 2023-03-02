package com.ags.lcz.core.database.di

import android.content.Context
import androidx.room.Room
import com.ags.lcz.core.database.AppDatabase
import com.ags.lcz.core.database.UserInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 * desc: 用于保存数据库并作为应用持久性数据底层连接的主要访问点。
 *
 * create by lcz on 2023-03-02
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideUserInfoDao(appDatabase: AppDatabase): UserInfoDao {
        return appDatabase.userDao()
    }


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "lczRoomTable").build()
    }
}