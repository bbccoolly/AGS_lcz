package com.ags.lcz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ags.lcz.R
import com.ags.lcz.adapter.BannerAdapter
import com.ags.lcz.adapter.HomeFragmentAdapter
import com.ags.lcz.binding.ViewBinding
import com.ags.lcz.core.model.playandroid.TabEntity
import com.ags.lcz.databinding.FragmentHomeBinding
import com.ags.lcz.util.ColorTypeUtils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.skydoves.bindables.BindingFragment
import com.skydoves.whatif.whatIfNotNull
import com.zhpan.indicator.enums.IndicatorSlideMode
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.ArrayList

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var fragmentAdapter: HomeFragmentAdapter
    private val fragmentList = listOf(
        TabEntity(HomeFragmentAdapter.TAB_HOME_HOME),
        TabEntity(HomeFragmentAdapter.TAB_HOME_SQUARE),
        TabEntity(HomeFragmentAdapter.TAB_HOME_QA)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            vm = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentAdapter = HomeFragmentAdapter(fragmentList, this.childFragmentManager, lifecycle)
        binding.homeViewPager2.adapter = fragmentAdapter
        TabLayoutMediator(
            binding.tabLayout,
            binding.homeViewPager2
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = fragmentAdapter.item[position].title
        }.apply(TabLayoutMediator::attach)
    }

    companion object {
        const val KEY_CHILD_HOME_TAB_PARCELABLE = "key_child_tab_parcelable"
    }

}