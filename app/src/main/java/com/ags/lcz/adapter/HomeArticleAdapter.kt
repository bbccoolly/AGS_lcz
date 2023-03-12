package com.ags.lcz.adapter

import android.os.SystemClock
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ags.lcz.R
import com.ags.lcz.core.model.playandroid.ArticleDetailEntity
import com.ags.lcz.databinding.ItemRecyclerviewPlayAndroidBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding
import timber.log.Timber

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-12
 */
class HomeArticleAdapter :
    BindingListAdapter<ArticleDetailEntity, HomeArticleAdapter.HomeArticleViewHolder>(diffUtil) {

    private var onClickedAt = 0L

    override fun onBindViewHolder(holder: HomeArticleViewHolder, position: Int) {
        holder.bindArticle(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeArticleViewHolder =
        parent.binding<ItemRecyclerviewPlayAndroidBinding>(R.layout.item_recyclerview_play_android)
            .let(::HomeArticleViewHolder)

    inner class HomeArticleViewHolder constructor(
        private val binding: ItemRecyclerviewPlayAndroidBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                val currentClickedAt = SystemClock.elapsedRealtime()
                if (currentClickedAt - onClickedAt > binding.transformationLayout.duration) {
//                    DetailActivity.startActivity(binding.transformationLayout, getItem(position))
                    Toast.makeText(it.context, "SSSS" + position, Toast.LENGTH_SHORT).show()
                    onClickedAt = currentClickedAt
                }
            }

        }

        fun bindArticle(item: ArticleDetailEntity?) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<ArticleDetailEntity>() {

            override fun areItemsTheSame(
                oldItem: ArticleDetailEntity,
                newItem: ArticleDetailEntity
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ArticleDetailEntity,
                newItem: ArticleDetailEntity
            ): Boolean =
                oldItem == newItem
        }
    }

}