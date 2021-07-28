package com.ghozadev.movieapp.ui.movie

import com.ghozadev.movieapp.data.FilmEntity

interface FilmFragmentCallback {
    fun onShareClick(film: FilmEntity)
}
