package com.ghozadev.movieapp.data

import androidx.lifecycle.LiveData

interface FilmDataSource {

    fun getPopularMovies(): LiveData<List<FilmEntity>>

    fun getMovieDetail(movieId: Int): LiveData<FilmEntity>

    fun getPopularTvShow(): LiveData<List<FilmEntity>>

    fun getTvShowDetail(tvShowId: Int): LiveData<FilmEntity>
}