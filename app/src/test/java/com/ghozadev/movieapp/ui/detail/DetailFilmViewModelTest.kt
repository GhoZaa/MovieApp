package com.ghozadev.movieapp.ui.detail

import com.ghozadev.movieapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailFilmViewModelTest {

    private lateinit var viewModel: DetailFilmViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieTitle = dummyMovie.title
    private val tvShowTitle = dummyTvShow.title

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel()
        viewModel.setSelectedFilm(movieTitle)
        viewModel.setSelectedFilm(tvShowTitle)
    }

    @Test
    fun getFilm() {
        viewModel.setSelectedFilm(dummyMovie.title)
        val movieEntity = viewModel.getFilm()
        assertNotNull(movieEntity)
        if (movieEntity != null) {
            assertEquals(dummyMovie.title, movieEntity.title)
            assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
            assertEquals(dummyMovie.description, movieEntity.description)
            assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        }

        viewModel.setSelectedFilm(dummyTvShow.title)
        val tvShowEntity = viewModel.getFilm()
        assertNotNull(tvShowEntity)
        if (tvShowEntity != null) {
            assertEquals(dummyTvShow.title, tvShowEntity.title)
            assertEquals(dummyTvShow.releaseDate, tvShowEntity.releaseDate)
            assertEquals(dummyTvShow.description, tvShowEntity.description)
            assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        }
    }

}