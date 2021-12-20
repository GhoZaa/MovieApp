package com.ghozadev.movieapp.data.source.remote.api

import com.ghozadev.movieapp.BuildConfig
import com.ghozadev.movieapp.data.source.remote.response.ListResponse
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
//        @Query("page") page: String = "2"
    ) : Call<ListResponse<MovieResponse>>

    @GET("tv/popular")
    fun getPopularTvShow(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ) : Call<ListResponse<TvShowResponse>>

    @GET("search/movie")
    fun getSearchMovieResult(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("query") query : String
    ) : Call<ListResponse<MovieResponse>>

    @GET("search/tv")
    fun getSearchTvShowResult(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("query") query : String
    ) : Call<ListResponse<TvShowResponse>>

}