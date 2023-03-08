package com.ags.lcz.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.ags.lcz.R
import com.ags.lcz.databinding.ActivityMainBinding
import com.skydoves.bindables.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding {
            vm = viewModel
        }
        viewModel.fetchNextPokemonList()

    }

    override fun onResume() {
        super.onResume()
//        Timber.d("viewModel.pokemonList - " + viewModel.pokemonList[0])
    }
}