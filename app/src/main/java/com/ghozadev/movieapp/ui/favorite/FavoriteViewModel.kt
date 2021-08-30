package com.ghozadev.movieapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val filmRepository: FilmRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = filmRepository.getFavoriteMovies()

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = filmRepository.getFavoriteTvShows()
}
