/*
 * Designed and developed by 2022 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ags.lcz.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ags.lcz.ui.MainViewModel
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.whatif.whatIfNotNullAs

object RecyclerViewBinding {

  @JvmStatic
  @BindingAdapter("adapter")
  fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter.apply {
//      stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }
  }

  @JvmStatic
  @BindingAdapter("submitList")
  fun bindSubmitList(view: RecyclerView, itemList: List<Any>?) {
    view.adapter.whatIfNotNullAs<BindingListAdapter<Any, *>> { adapter ->
      adapter.submitList(itemList)
    }
  }

//  @JvmStatic
//  @BindingAdapter("paginationPokemonList")
//  fun paginationPokemonList(view: RecyclerView, viewModel: MainViewModel) {
//    RecyclerViewPaginator(
//      recyclerView = view,
//      isLoading = { viewModel.isLoading },
//      loadMore = { viewModel.fetchNextPokemonList() },
//      onLast = { false }
//    ).run {
//      threshold = 8
//    }
//  }
}
