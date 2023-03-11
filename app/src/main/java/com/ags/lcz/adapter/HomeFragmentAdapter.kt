package com.ags.lcz.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ags.lcz.core.model.playandroid.TabEntity
import com.ags.lcz.ui.home_child.HomeChildFragment
import com.ags.lcz.ui.home_qa.HomeQAFragment
import com.ags.lcz.ui.home_square.HomeSquareFragment

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023-03-12
 */
class HomeFragmentAdapter(
    var item: List<TabEntity>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return item.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (item[position].title) {
            TAB_HOME_HOME -> HomeChildFragment.newInstance(item[position])
            TAB_HOME_SQUARE -> HomeSquareFragment.newInstance(item[position])
            TAB_HOME_QA -> HomeQAFragment.newInstance(item[position])
            else -> HomeChildFragment.newInstance(item[position])
        }
    }

    companion object {
        const val TAB_HOME_HOME = "首页"
        const val TAB_HOME_SQUARE = "广场"
        const val TAB_HOME_QA = "问答"
    }
}