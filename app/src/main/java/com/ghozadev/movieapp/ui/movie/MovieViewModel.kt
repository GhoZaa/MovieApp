package com.ghozadev.movieapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.source.remote.FilmRepository

class MovieViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovies(): LiveData<List<FilmEntity>> = filmRepository.getPopularMovies()
}