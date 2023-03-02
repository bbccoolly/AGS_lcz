package com.ags.lcz.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ags.lcz.core.database.entity.UserInfoEntity

/**
 *
 * desc: 用于保存数据库并作为应用持久性数据底层连接的主要访问点。
 *
 * create by lcz on 2023-03-02
 */
@Database(entities = [UserInfoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao():UserInfoDao

}