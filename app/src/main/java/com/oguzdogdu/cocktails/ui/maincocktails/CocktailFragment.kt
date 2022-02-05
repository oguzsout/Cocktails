package com.oguzdogdu.cocktails.ui.maincocktails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguzdogdu.cocktails.base.BaseFragment
import com.oguzdogdu.cocktails.databinding.FragmentCocktailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailFragment :
    BaseFragment<FragmentCocktailBinding>(FragmentCocktailBinding::inflate) {
    private val viewModel: CocktailViewModel by viewModels()
    private val cocktailAdapter = CocktailAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        binding.rvCocktail.apply {
            adapter = cocktailAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun observeData() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.cocktailList.collect { cocktailState ->
                cocktailState.data.also {
                    if (it != null) {
                        cocktailAdapter.drinks = it
                    }
                }
            }
        }
    }
}
