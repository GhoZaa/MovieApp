package com.ghozadev.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.FilmRepository

class DetailFilmViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(movieId: Int): LiveData<FilmEntity> = filmRepository.getMovieDetail(movieId)

    fun getTvShow(tvShowId: Int): LiveData<FilmEntity> = filmRepository.getTvShowDetail(tvShowId)
}