package com.ghozadev.movieapp.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.source.FilmDataSource
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.data.source.remote.response.TvShowResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource) : FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteDataSource)
            }
    }

    override fun getPopularMovies(): LiveData<List<FilmEntity>> {
        val listMovieResults = MutableLiveData<List<FilmEntity>>()

        CoroutineScope(IO).launch {
            remoteDataSource.getPopularMovies(object: RemoteDataSource.LoadPopularMoviesCallback {
                override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<FilmEntity>()
                    for (response in movieResponse) {
                        val movie = FilmEntity(
                            response.id,
                            response.title,
                            response.backdropPath,
                            response.posterPath,
                            response.releaseDate,
                            response.description
                        )
                        movieList.add(movie)
                    }
                    listMovieResults.postValue(movieList)
                }
            })
        }
        return listMovieResults
    }

    override fun getMovieDetail(movieId: Int): LiveData<FilmEntity> {
        val movieResult = MutableLiveData<FilmEntity>()

        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetailCallback {
                override fun onMovieDetailReceived(movieResponse: MovieResponse) {
                    val movie = FilmEntity(
                        movieResponse.id,
                        movieResponse.title,
                        movieResponse.backdropPath,
                        movieResponse.posterPath,
                        movieResponse.releaseDate,
                        movieResponse.description
                    )
                    movieResult.postValue(movie)
                }
            })
        }
        return movieResult
    }

    override fun getPopularTvShow(): LiveData<List<FilmEntity>> {
        val listTvShowResults = MutableLiveData<List<FilmEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getPopularTvShows(object : RemoteDataSource.LoadPopularTvShowsCallback {
                override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                    val tvShowList = ArrayList<FilmEntity>()
                    for (response in tvShowResponse) {
                        val tvShow = FilmEntity(
                            response.id,
                            response.title,
                            response.backdropPath,
                            response.posterPath,
                            response.releaseDate,
                            response.description
                        )
                        tvShowList.add(tvShow)
                    }
                    listTvShowResults.postValue(tvShowList)
                }
            })
        }
        return listTvShowResults
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<FilmEntity> {
        val tvShowResult = MutableLiveData<FilmEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetailCallback {
                override fun onTvShowDetailReceived(tvShowResponse: TvShowResponse) {
                    val tvShow = FilmEntity(
                        tvShowResponse.id,
                        tvShowResponse.title,
                        tvShowResponse.backdropPath,
                        tvShowResponse.posterPath,
                        tvShowResponse.releaseDate,
                        tvShowResponse.description
                    )
                    tvShowResult.postValue(tvShow)
                }
            })
        }
        return tvShowResult
    }

}