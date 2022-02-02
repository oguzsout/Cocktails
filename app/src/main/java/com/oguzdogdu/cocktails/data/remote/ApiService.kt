package com.oguzdogdu.cocktails.data.remote

import com.oguzdogdu.cocktails.data.model.DrinkList
import retrofit2.http.GET

interface ApiService {

    @GET("random.php")
    suspend fun getCocktails(): DrinkList
}