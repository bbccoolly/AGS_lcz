package com.ags.lcz.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ags.lcz.core.database.entity.UserInfoEntity

/**
 *
 * desc: 提供您的应用可用于查询、更新、插入和删除数据库中的数据的方法。
 *
 * create by lcz on 2023-03-02
 */
@Dao
interface UserInfoDao {
    @Query("SELECT * FROM user")
    fun getAllUserInfo(): List<UserInfoEntity>

    @Insert
    suspend fun insertUserInfoItem(item: UserInfoEntity)

}