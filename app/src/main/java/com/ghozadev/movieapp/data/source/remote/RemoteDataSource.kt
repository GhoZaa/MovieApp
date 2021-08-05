package com.ghozadev.movieapp.data.source.remote

import com.ghozadev.movieapp.data.source.remote.api.ApiConfig
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import com.ghozadev.movieapp.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource()
        }
    }

    suspend fun getPopularMovies(callback: LoadPopularMoviesCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getPopularMovies().await().result?.let { movies ->
            callback.onAllMoviesReceived(movies)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailMovie(movieId).await().let { movie ->
            callback.onMovieDetailReceived(movie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getPopularTvShows(callback: LoadPopularTvShowsCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getPopularTvShow().await().result?.let { tvShows ->
            callback.onAllTvShowReceived(tvShows)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.instance.getDetailTvShow(tvShowId).await().let { tvShow ->
            callback.onTvShowDetailReceived(tvShow)
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadPopularMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(movieResponse: MovieResponse)
    }

    interface LoadPopularTvShowsCallback {
        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>)
    }

    interface LoadTvShowDetailCallback {
        fun onTvShowDetailReceived(tvShowResponse: TvShowResponse)
    }

}