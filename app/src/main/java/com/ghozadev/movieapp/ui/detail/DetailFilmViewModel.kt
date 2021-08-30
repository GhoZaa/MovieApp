package com.ghozadev.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import javax.inject.Inject

class DetailFilmViewModel @Inject constructor(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovie(movieId: Int): LiveData<MovieEntity> = filmRepository.getMovieDetail(movieId)

    fun getTvShow(tvShowId: Int): LiveData<TvShowEntity> = filmRepository.getTvShowDetail(tvShowId)

    fun setFavoriteMovie(movie: MovieEntity) {
        filmRepository.setFavoriteMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        filmRepository.setFavoriteTvShow(tvShow)
    }
}