package com.ghozadev.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.utils.DataDummy

class DetailFilmViewModel : ViewModel() {

    private lateinit var filmTitle: String

    fun setSelectedFilm(filmTitle: String) {
        this.filmTitle = filmTitle
    }

    fun getFilm(): FilmEntity? {
        var film: FilmEntity? = null
        for (movieEntity in DataDummy.generateDummyMovies()) {
            if (movieEntity.title == filmTitle) {
                film = movieEntity
            }
        }

        for (tvShowEntity in DataDummy.generateDummyTvShows()) {
            if (tvShowEntity.title == filmTitle) {
                film = tvShowEntity
            }
        }

        return film
    }
}