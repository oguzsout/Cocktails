package com.oguzdogdu.cocktails.ui.cocktaildetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.RoundedCornersTransformation
import com.oguzdogdu.cocktails.base.BaseFragment
import com.oguzdogdu.cocktails.databinding.FragmentCocktailDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailDetailsFragment :
    BaseFragment<FragmentCocktailDetailsBinding>(FragmentCocktailDetailsBinding::inflate) {
    private val args: CocktailDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        val drinkList = args.drinks
        binding.cocktailTitle.text = drinkList.title
        binding.cocktailDesc.text = drinkList.description
        binding.imgCocktail.load(drinkList.image) {
            transformations(RoundedCornersTransformation(25f))
        }
    }
}