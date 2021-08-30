package com.ghozadev.movieapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("id")
	val id: Int = 0,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("overview")
	val description: String? = null
)
