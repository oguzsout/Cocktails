package com.oguzdogdu.cocktails.data.model

import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strAlcoholic")
    val isAlcoholic: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strDrink")
    val title: String,
    @SerializedName("strDrinkThumb")
    val image: String,
)

data class DrinkList(
    @SerializedName("drinks")
    val drinksList: List<Drink> = listOf()
)