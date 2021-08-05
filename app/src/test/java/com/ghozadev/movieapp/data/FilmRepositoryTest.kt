package com.ghozadev.movieapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource
import com.ghozadev.movieapp.data.source.remote.response.MovieResponse
import com.ghozadev.movieapp.utils.DataDummy
import com.ghozadev.movieapp.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Test
import org.junit.Rule
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val listMovieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = listMovieResponse[0].id
    private val listTvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.generateRemoteDummyMovies()[0]
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()[0]

    @Test
    suspend fun getPopularMovies() {
        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularMoviesCallback).onAllMoviesReceived(listMovieResponse)
            null
        }.`when`(remote).getPopularMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getPopularMovies())

        verify(remote).getPopularMovies(any())

        assertNotNull(movieEntities)
        assertEquals(listMovieResponse.size.toLong(), movieEntities.size.toLong())
    }
}