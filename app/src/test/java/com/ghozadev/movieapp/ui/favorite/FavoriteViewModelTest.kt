package com.ghozadev.movieapp.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(filmRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovies = moviePagedList
        Mockito.`when`(dummyMovies.size).thenReturn(10)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovies

        Mockito.`when`(filmRepository.getFavoriteMovies()).thenReturn(movie)
        val movieEntities = viewModel.getFavoriteMovies().value
        Mockito.verify(filmRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyTvShows = tvShowPagedList
        Mockito.`when`(dummyTvShows.size).thenReturn(10)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShows

        Mockito.`when`(filmRepository.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getFavoriteTvShows().value
        Mockito.verify(filmRepository).getFavoriteTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity?.size)

        viewModel.getFavoriteTvShows().observeForever(tvShowObserver)
        Mockito.verify(tvShowObserver).onChanged(dummyTvShows)
    }
}