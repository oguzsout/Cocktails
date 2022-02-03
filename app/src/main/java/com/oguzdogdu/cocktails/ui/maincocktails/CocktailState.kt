package com.oguzdogdu.cocktails.ui.maincocktails

import com.oguzdogdu.cocktails.data.model.Drink
import com.oguzdogdu.cocktails.data.model.DrinkList
import com.oguzdogdu.cocktails.domain.model.Cocktails

data class CocktailState(
    val isLoading: Boolean = false,
    val data: List<Drink>? = null,
    val error: String = ""
)
