package com.oguzdogdu.cocktails.ui.maincocktails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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
        searchViewSetup()
        observeData()
    }

    private fun setupRecyclerView() {
        binding.rvCocktail.apply {
            adapter = cocktailAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            hideProgressBar()
        }
    }

    private fun searchViewSetup() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(cocktailName: String?): Boolean {
                cocktailName?.let {
                    viewModel.getSearchCocktails(it)
                    showProgressBar()
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }

    private fun observeData() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.cocktailList.collect { cocktailState ->
                when {
                    cocktailState.isLoading -> showProgressBar()
                    cocktailState.error.isNotEmpty() -> {
                        hideProgressBar()
                        Toast.makeText(requireContext(), cocktailState.error, Toast.LENGTH_SHORT)
                            .show()
                    }
                    cocktailState.data?.isNotEmpty() == true -> {
                        hideProgressBar()
                        cocktailAdapter.drinks = cocktailState.data
                    }
                }
//                if (cocktailState.isLoading) {
//                    showProgressBar()
//                }
//                if (cocktailState.error.isNotBlank()) {
//                    hideProgressBar()
//                    Toast.makeText(requireContext(), cocktailState.error, Toast.LENGTH_SHORT).show()
//                }
//
//                cocktailState.data?.let {
//                    hideProgressBar()
//                    cocktailAdapter.drinks = it
//              }
            }
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }
}