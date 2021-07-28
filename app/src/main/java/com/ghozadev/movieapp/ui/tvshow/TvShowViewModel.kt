package com.ghozadev.movieapp.ui.tvshow

import androidx.lifecycle.ViewModel
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<FilmEntity> = DataDummy.generateDummyTvShows()
}