package com.ghozadev.movieapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {

    private lateinit var viewModel: DetailFilmViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var filmObserver: Observer<FilmEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<FilmEntity>()
        movie.value = dummyMovie

        `when`(filmRepository.getMovieDetail(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovie(movieId).value as FilmEntity
        verify(filmRepository).getMovieDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.description, movieEntity.description)

        viewModel.getMovie(movieId).observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyMovie)
    }


    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<FilmEntity>()
        tvShow.value = dummyTvShow

        `when`(filmRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow(tvShowId).value as FilmEntity
        verify(filmRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)
        assertEquals(dummyTvShow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTvShow.description, tvShowEntity.description)

        viewModel.getTvShow(tvShowId).observeForever(filmObserver)
        verify(filmObserver).onChanged(dummyTvShow)
    }

}