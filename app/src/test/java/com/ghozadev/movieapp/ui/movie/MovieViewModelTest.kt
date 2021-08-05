package com.ghozadev.movieapp.ui.movie

import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        `when`(filmRepository.getPopularMovies()).thenReturn(DataDummy.generateDummyMovies() as ArrayList<FilmEntity>)
        val movieEntities = viewModel.getMovies()
        verify<FilmRepository>(filmRepository).getPopularMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}