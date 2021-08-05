package com.ghozadev.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.FilmRepository

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    private var filmId: Int = 0

    fun setSelectedFilm(filmId: Int) {
        this.filmId = filmId
    }

//    fun getMovie(): LiveData<FilmEntity> = filmRepository.getMovieDetail(filmId)
//
//    fun getTvShow(): LiveData<FilmEntity> = filmRepository.getTvShowDetail(filmId)

    fun getMovie(movieId: Int): LiveData<FilmEntity> = filmRepository.getMovieDetail(movieId)

    fun getTvShow(tvShowId: Int): LiveData<FilmEntity> = filmRepository.getTvShowDetail(tvShowId)
}