package com.oguzdogdu.cocktails.ui.maincocktails

import com.oguzdogdu.cocktails.domain.model.Cocktails

data class CocktailState(
    val isLoading: Boolean = false,
    val data: List<Cocktails>? = null,
    val error: String = ""
)
