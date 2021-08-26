package com.ghozadev.movieapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ghozadev.movieapp.data.source.remote.api.ApiConfig
import com.ghozadev.movieapp.data.source.remote.api.ApiService
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import com.ghozadev.movieapp.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException

class RemoteDataSource constructor(private val catalogApiService: ApiService){

//    companion object {
//        @Volatile
//        private var instance: RemoteDataSource? = null
//
//        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
//            instance ?: RemoteDataSource()
//        }
//    }

    fun getPopularMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = catalogApiService.getPopularMovies().await()
                resultMovieResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovieResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovieResponse
    }

//    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
//        EspressoIdlingResource.increment()
//        ApiConfig.instance.getDetailMovie(movieId).await().let { movie ->
//            callback.onMovieDetailReceived(movie)
//            EspressoIdlingResource.decrement()
//        }
//    }

    fun getPopularTvShows(): MutableLiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = catalogApiService.getPopularTvShow().await()
                resultTvShowResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShowResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShowResponse
    }

//    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback) {
//        EspressoIdlingResource.increment()
//        ApiConfig.instance.getDetailTvShow(tvShowId).await().let { tvShow ->
//            callback.onTvShowDetailReceived(tvShow)
//            EspressoIdlingResource.decrement()
//        }
//    }

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