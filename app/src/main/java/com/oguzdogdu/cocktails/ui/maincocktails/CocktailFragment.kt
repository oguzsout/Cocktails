package com.oguzdogdu.cocktails.ui.maincocktails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.oguzdogdu.cocktails.base.BaseFragment
import com.oguzdogdu.cocktails.databinding.FragmentCocktailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailFragment :
    BaseFragment<FragmentCocktailBinding>(FragmentCocktailBinding::inflate) {
    private val viewModel: CocktailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.cocktailList.collect { cocktails ->
                Toast.makeText(requireContext(), cocktails.data.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
