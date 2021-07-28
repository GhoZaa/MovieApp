package com.ghozadev.movieapp.data

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable

data class FilmEntity(
    var title: String,
    var releaseDate: String,
    var description: String,
    var imagePath: Int
)
