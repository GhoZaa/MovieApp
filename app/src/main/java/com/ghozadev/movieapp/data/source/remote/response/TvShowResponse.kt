package com.ghozadev.movieapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val title: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("first_air_date")
	val releaseDate: String,

	@field:SerializedName("overview")
	val description: String
)
