package com.ags.lcz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ags.lcz.R
import com.ags.lcz.adapter.BannerAdapter
import com.ags.lcz.binding.ViewBinding
import com.ags.lcz.databinding.FragmentHomeBinding
import com.ags.lcz.util.ColorTypeUtils
import com.skydoves.bindables.BindingFragment
import com.skydoves.whatif.whatIfNotNull
import com.zhpan.indicator.enums.IndicatorSlideMode
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.ArrayList

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initBannerData()
        initViewPager()
        return binding {
            vm = viewModel
        }.root
    }


    private fun initBannerData() {
        viewModel.bannerInfo.observe(viewLifecycleOwner) {
            Timber.d("observe - "+it.size)
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