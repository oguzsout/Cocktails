package com.oguzdogdu.cocktails.data.model

import com.google.gson.annotations.SerializedName

data class DrinkList(
    @SerializedName("drinks")
    val drink: List<Drink>
)
