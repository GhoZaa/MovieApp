package com.ghozadev.movieapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmEntity(
    var id: Int = 0,
    var title: String,
    var backdropPath: String,
    var posterPath: String,
    var releaseDate: String,
    var description: String
) : Parcelable
