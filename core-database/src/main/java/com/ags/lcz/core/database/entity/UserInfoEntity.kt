package com.ags.lcz.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * desc: 用于表示应用的数据库中的表。
 *
 * create by lcz on 2023-03-02
 */
@Entity
data class UserInfoEntity(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
