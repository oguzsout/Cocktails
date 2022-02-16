package com.oguzdogdu.cocktails.domain.repository

import com.oguzdogdu.cocktails.data.model.DrinkList


interface CocktailsRepoInterface {
    suspend fun getCocktailByName(cocktailName: String): DrinkList
}