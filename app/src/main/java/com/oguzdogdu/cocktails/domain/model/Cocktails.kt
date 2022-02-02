package com.oguzdogdu.cocktails.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktails(
    val id: String,
    val isAlcoholic: String,
    val category: String,
    val title: String,
    val image: String,
) : Parcelable
