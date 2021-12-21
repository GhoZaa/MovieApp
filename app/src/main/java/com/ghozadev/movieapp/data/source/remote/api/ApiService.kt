package com.ghozadev.movieapp.data.source.remote.api

import com.ghozadev.movieapp.BuildConfig
import com.ghozadev.movieapp.data.source.remote.response.ListResponse
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import com.ghozadev.movieapp.data.source.remote.response.VideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ListResponse<MovieResponse>>

    @GET("tv/popular")
    fun getPopularTvShow(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ListResponse<TvShowResponse>>

    @GET("search/movie")
    fun getSearchMovieResult(
        @Query("api_key") apiKey: String,
        @Query("query") query : String
    ) : Call<ListResponse<MovieResponse>>

    @GET("search/tv")
    fun getSearchTvShowResult(
        @Query("api_key") apiKey: String,
        @Query("query") query : String
    ) : Call<ListResponse<TvShowResponse>>

    @GET("movie/{id}/videos")
    fun getMovieVideos(
        @Path("id") movieId : Int?,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ListResponse<VideoResponse>>

    @GET("tv/{id}/videos")
    fun getTvShowVideos(
        @Path("id") tvShowId : Int?,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ListResponse<VideoResponse>>
}