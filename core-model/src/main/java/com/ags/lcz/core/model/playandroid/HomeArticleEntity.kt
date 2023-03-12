package com.ags.lcz.core.model.playandroid

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-12
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class HomeArticleEntity(
    val curPage: Int? = 1,
    val datas: List<ArticleDetailEntity>? = null,
    val offset: Int? = 1,
    val over: Boolean? = false,
    val pageCount: Int? = 1,
    val size: Int? = 1,
    val total: Int? = 1
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ArticleDetailEntity(
    val adminAdd: Boolean,
    val apkLink: String,
    val audit: Int,
    val author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val host: String,
    val id: Int,
    val isAdminAdd: Boolean,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val route: Boolean,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val articleTagEntities: List<ArticleTagEntity>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ArticleTagEntity(
    val name: String,
    val url: String
) : Parcelable