package com.oguzdogdu.cocktails.data.repository

import com.oguzdogdu.cocktails.data.model.DrinkList
import com.oguzdogdu.cocktails.data.remote.ApiService
import com.oguzdogdu.cocktails.domain.repository.CocktailsRepoInterface

import javax.inject.Inject

class CocktailsRepoImpl @Inject constructor(
    private val service: ApiService):
    CocktailsRepoInterface {
    override suspend fun getCocktailByName(cocktailName: String): DrinkList {
        return service.getCocktails(cocktailName)
    }
}