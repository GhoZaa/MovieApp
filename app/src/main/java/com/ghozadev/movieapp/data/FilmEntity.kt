package com.ghozadev.movieapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmEntity(
    var id: Int = 0,
    var title: String? = null,
    var backdropPath: String? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var description: String,
    var type: String,
) : Parcelable
