package com.ghozadev.movieapp.data.source

import androidx.lifecycle.LiveData
import com.ghozadev.movieapp.data.FilmEntity

interface FilmDataSource {

    fun getPopularMovies(): LiveData<List<FilmEntity>>

    fun getMovieDetail(movieId: Int): LiveData<FilmEntity>

    fun getPopularTvShow(): LiveData<List<FilmEntity>>

    fun getTvShowDetail(tvShowId: Int): LiveData<FilmEntity>
}