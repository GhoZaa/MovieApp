package com.ghozadev.movieapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource
import com.ghozadev.movieapp.utils.DataDummy
import com.ghozadev.movieapp.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

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
    fun getPopularMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadPopularMoviesCallback)
                    .onAllMoviesReceived(listMovieResponse)
                null
            }.`when`(remote).getPopularMovies(any())
        }

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getPopularMovies())

        runBlocking {
            verify(remote).getPopularMovies(any())
        }

        assertNotNull(movieEntities)
        assertEquals(listMovieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback)
                    .onMovieDetailReceived(movieResponse)
                null
            }.`when`(remote).getMovieDetail(eq(movieId), any())
        }

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getMovieDetail(movieId))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId), any())
        }

        assertNotNull(movieEntities)
        assertEquals(movieResponse.id, movieEntities.id)
        assertEquals(movieResponse.title, movieEntities.title)
        assertEquals(movieResponse.releaseDate, movieEntities.releaseDate)
        assertEquals(movieResponse.posterPath, movieEntities.posterPath)
        assertEquals(movieResponse.description, movieEntities.description)
    }

    @Test
    fun getPopularTvShow() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadPopularTvShowsCallback)
                    .onAllTvShowReceived(listTvShowResponse)
                null
            }.`when`(remote).getPopularTvShows(any())
        }

        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getPopularTvShow())

        runBlocking {
            verify(remote).getPopularTvShows(any())
        }

        assertNotNull(tvShowEntities)
        assertEquals(listTvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getTvShowDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as RemoteDataSource.LoadTvShowDetailCallback).onTvShowDetailReceived(tvShowResponse)
                null
            }.`when`(remote).getTvShowDetail(eq(tvShowId), any())
        }

        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getTvShowDetail(tvShowId))

        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId), any())
        }

        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.id, tvShowEntities.id)
        assertEquals(tvShowResponse.title, tvShowEntities.title)
        assertEquals(tvShowResponse.releaseDate, tvShowEntities.releaseDate)
        assertEquals(tvShowResponse.posterPath, tvShowEntities.posterPath)
        assertEquals(tvShowResponse.description, tvShowEntities.description)
    }
}