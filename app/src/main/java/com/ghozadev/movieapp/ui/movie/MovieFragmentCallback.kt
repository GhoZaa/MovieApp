package com.ghozadev.movieapp.ui.movie

import com.ghozadev.movieapp.data.source.local.entity.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(data: MovieEntity)

    fun onItemClicked(data: MovieEntity)
}
