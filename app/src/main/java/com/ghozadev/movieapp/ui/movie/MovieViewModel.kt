package com.ghozadev.movieapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.vo.Resource
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getPopularMovies()

    fun getSearchMovie(title : String): LiveData<Resource<PagedList<MovieEntity>>> =
        filmRepository.getSearchMovie(title)
}