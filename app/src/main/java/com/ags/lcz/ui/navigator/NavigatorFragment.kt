package com.ags.lcz.ui.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ags.lcz.R

class NavigatorFragment : Fragment() {

    companion object {
        fun newInstance() = NavigatorFragment()
    }

    private lateinit var viewModel: NavigatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigator, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NavigatorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}