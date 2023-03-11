package com.ags.lcz.adapter

import android.view.View
import android.view.ViewGroup
import com.ags.lcz.R
import com.ags.lcz.databinding.ItemBannerViewpagerBinding
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-11
 */
class BannerAdapter(private val mRoundCorner: Int) : BaseBannerAdapter<Int>() {

    override fun createViewHolder(
        parent: ViewGroup, itemView: View, viewType: Int
    ): BaseViewHolder<Int> {
        return ViewBindingViewHolder(ItemBannerViewpagerBinding.bind(itemView))
    }

    override fun bindData(holder: BaseViewHolder<Int>, data: Int, position: Int, pageSize: Int) {
        if (holder is ViewBindingViewHolder) {
            holder.viewBinding.ivBanner.setImageResource(data)
            holder.viewBinding.ivBanner.setRoundCorner(mRoundCorner)
        }
    }


    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_banner_viewpager
    }
}

internal class ViewBindingViewHolder(var viewBinding: ItemBannerViewpagerBinding) :
    BaseViewHolder<Int>(viewBinding.root)
