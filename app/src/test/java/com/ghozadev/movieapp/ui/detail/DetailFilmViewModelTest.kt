package com.ghozadev.movieapp.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
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
    private val movieId = dummyMovie.movieId
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(filmRepository.getMovieDetail(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovie(movieId).value as MovieEntity
        verify(filmRepository).getMovieDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.description, movieEntity.description)

        viewModel.getMovie(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(filmRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow(tvShowId).value as TvShowEntity
        verify(filmRepository).getTvShowDetail(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)
        assertEquals(dummyTvShow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTvShow.description, tvShowEntity.description)

        viewModel.getTvShow(tvShowId).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

}