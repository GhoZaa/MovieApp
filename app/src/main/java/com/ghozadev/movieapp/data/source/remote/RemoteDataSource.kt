package com.ghozadev.movieapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ghozadev.movieapp.BuildConfig
import com.ghozadev.movieapp.data.source.remote.api.ApiService
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import com.ghozadev.movieapp.data.source.remote.response.VideoResponse
import com.ghozadev.movieapp.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getPopularMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getPopularMovies().await()
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

    fun getPopularTvShows(): MutableLiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getPopularTvShow().await()
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

    fun getSearchMovieResult(querySearch : String): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovieResponse = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getSearchMovieResult(BuildConfig.TMDB_API_KEY, querySearch).await()
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

    fun getMovieVideos(filmId : Int?): LiveData<ApiResponse<List<VideoResponse>>> {
        EspressoIdlingResource.increment()
        val resultVideoResponse = MutableLiveData<ApiResponse<List<VideoResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getMovieVideos(filmId, BuildConfig.TMDB_API_KEY).await()
                resultVideoResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultVideoResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultVideoResponse
    }

    fun getSearchTvShowResult(querySearch : String): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShowResponse = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getSearchTvShowResult(BuildConfig.TMDB_API_KEY, querySearch).await()
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

}