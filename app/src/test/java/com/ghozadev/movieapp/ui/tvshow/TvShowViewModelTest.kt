package com.ghozadev.movieapp.ui.tvshow

import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {
        Mockito.`when`(filmRepository.getPopularTvShow())
            .thenReturn(DataDummy.generateDummyTvShows() as ArrayList<FilmEntity>)
        val tvShowEntities = viewModel.getTvShow()
        verify<FilmRepository>(filmRepository).getPopularTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}