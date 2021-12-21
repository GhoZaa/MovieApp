package com.ghozadev.movieapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("key")
    val key: String? = null,

    @field:SerializedName("type")
    val type: String? = null
)
