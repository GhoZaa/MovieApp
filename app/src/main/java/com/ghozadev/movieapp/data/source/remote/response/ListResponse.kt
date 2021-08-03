package com.ghozadev.movieapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListResponse<T> (
    @SerializedName("results")
    val result: List<T>? = null
)