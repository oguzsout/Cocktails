package com.oguzdogdu.cocktails.ui.cocktaildetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oguzdogdu.cocktails.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cocktail_details, container, false)
    }
}