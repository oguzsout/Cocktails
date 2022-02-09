package com.oguzdogdu.cocktails.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.oguzdogdu.cocktails.domain.model.Cocktails
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strAlcoholic")
    val isAlcoholic: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strDrink")
    val title: String,
    @SerializedName("strInstructions")
    val description: String = "",
    @SerializedName("strDrinkThumb")
    val image: String,
) : Parcelable

//fun Drink.toCocktails(): Cocktails {
//    return Cocktails(
//        id, isAlcoholic, category, title, image
//    )
//}