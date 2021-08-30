package com.ghozadev.movieapp.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<FilmEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShows = DataDummy.generateDummyTvShows()
        val tvShows = MutableLiveData<List<FilmEntity>>()
        tvShows.value = dummyTvShows

        `when`(filmRepository.getPopularTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShow().value
        verify(filmRepository).getPopularTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}