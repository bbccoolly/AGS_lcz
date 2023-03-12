package com.ags.lcz.ui.home.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.ags.lcz.R
import com.ags.lcz.core.model.playandroid.TabEntity
import com.ags.lcz.databinding.FragmentHomeSquareBinding
import com.ags.lcz.ui.home.HomeFragment
import com.skydoves.bindables.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeSquareFragment :
    BindingFragment<FragmentHomeSquareBinding>(R.layout.fragment_home_square) {

    companion object {
        private const val KEY_HOME_FRAGMENT_LIST_SAVE_STATE = "key_home_fragment_list_save_state"

        fun newInstance(tabEntity: TabEntity): HomeSquareFragment = with(HomeSquareFragment()) {
            arguments = bundleOf(
                HomeFragment.KEY_CHILD_HOME_TAB_PARCELABLE to tabEntity
            )
            this

        }
    }

    private val viewModel: HomeSquareViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            vm = viewModel
        }.root
    }


}