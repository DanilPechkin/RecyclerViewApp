package com.example.recyclerviewapp.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val title: String,
    @DrawableRes val image: Int,
    val ingredients: String,
    val guide: String
    ) : Parcelable
