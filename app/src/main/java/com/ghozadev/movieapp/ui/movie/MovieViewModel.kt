package com.ghozadev.movieapp.ui.movie

import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.utils.DataDummy

class MovieViewModel: ViewModel() {

    fun getMovies(): List<FilmEntity> = DataDummy.generateDummyMovies()
}