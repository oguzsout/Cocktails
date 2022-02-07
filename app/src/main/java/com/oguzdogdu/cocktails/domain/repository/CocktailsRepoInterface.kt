package com.oguzdogdu.cocktails.domain.repository

import com.oguzdogdu.cocktails.data.model.Drink
import com.oguzdogdu.cocktails.data.model.DrinkList
import com.oguzdogdu.cocktails.util.Resource
import kotlinx.coroutines.flow.Flow

interface CocktailsRepoInterface {
    suspend fun getCocktailByName(cocktailName: String): DrinkList
}