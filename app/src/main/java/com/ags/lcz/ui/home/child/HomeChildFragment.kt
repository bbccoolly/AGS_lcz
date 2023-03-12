package com.ags.lcz.ui.home.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.ags.lcz.R
import com.ags.lcz.adapter.BannerAdapter
import com.ags.lcz.adapter.HomeArticleAdapter
import com.ags.lcz.binding.ViewBinding
import com.ags.lcz.core.model.playandroid.TabEntity
import com.ags.lcz.databinding.FragmentHomeChildBinding
import com.ags.lcz.ui.home.HomeFragment
import com.skydoves.bindables.BindingFragment
import com.skydoves.transformationlayout.onTransformationStartContainer
import com.zhpan.indicator.enums.IndicatorSlideMode
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeChildFragment : BindingFragment<FragmentHomeChildBinding>(R.layout.fragment_home_child) {

    private val viewModel: HomeChildViewModel by viewModels()

    companion object {
        private const val KEY_HOME_FRAGMENT_LIST_SAVE_STATE = "key_home_fragment_list_save_state"

        fun newInstance(tabEntity: TabEntity): HomeChildFragment = with(HomeChildFragment()) {
            arguments = bundleOf(
                HomeFragment.KEY_CHILD_HOME_TAB_PARCELABLE to tabEntity
            )
            this
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        onTransformationStartContainer()
        super.onCreateView(inflater, container, savedInstanceState)
        initBannerData()
        initViewPager()
        initRecycleView()
        return binding {
            binding.adapter = HomeArticleAdapter()
            vm = viewModel
        }.root
    }

    private fun initRecycleView() {

    }

    private fun initBannerData() {
        viewModel.bannerInfo.observe(viewLifecycleOwner) {
            Timber.d("observe - " + it.size)
            binding.bannerViewPager.create(it)
        }
    }

    private fun initViewPager() {
        val bannerAdapter = BannerAdapter(resources.getDimensionPixelOffset(R.dimen.dp_8))
        binding.bannerViewPager.apply {
            registerLifecycleObserver(lifecycle)
            setAdapter(bannerAdapter)
            setIndicatorSlideMode(IndicatorSlideMode.SCALE)
            setIndicatorSliderColor(
                resources.getColor(R.color.md_orange_200, null),
                resources.getColor(R.color.md_yellow_100, null)
            )
            setIndicatorSliderRadius(
                resources.getDimensionPixelOffset(R.dimen.dp_4),
                resources.getDimensionPixelOffset(R.dimen.dp_5)
            )
            setOnPageClickListener({ _: View, position: Int -> itemClick(position) }, true)
            setInterval(5000)
        }

    }

    private fun itemClick(position: Int) {
        ViewBinding.bindToast(binding.bannerViewPager, "点击了 $position")
    }


}