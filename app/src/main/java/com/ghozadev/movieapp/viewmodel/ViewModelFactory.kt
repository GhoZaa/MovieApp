package com.ghozadev.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.ui.detail.DetailFilmViewModel
import com.ghozadev.movieapp.ui.favorite.FavoriteViewModel
import com.ghozadev.movieapp.ui.movie.MovieViewModel
import com.ghozadev.movieapp.ui.tvshow.TvShowViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val mFilmRepository: FilmRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(DetailFilmViewModel::class.java) -> {
                DetailFilmViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}