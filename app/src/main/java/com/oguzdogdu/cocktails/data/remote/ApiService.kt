package com.oguzdogdu.cocktails.data.remote

import com.oguzdogdu.cocktails.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    suspend fun getCocktails(@Query("s") cocktailName: String): DrinkList
}