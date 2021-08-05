package com.ghozadev.movieapp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.FilmRepository

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShow(): LiveData<List<FilmEntity>> = filmRepository.getPopularTvShow()
}