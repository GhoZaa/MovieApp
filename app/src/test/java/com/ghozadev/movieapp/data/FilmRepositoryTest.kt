package com.ghozadev.movieapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ghozadev.movieapp.data.source.local.LocalDataSource
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource
import com.ghozadev.movieapp.utils.DataDummy
import com.ghozadev.movieapp.utils.LiveDataTestUtil
import com.ghozadev.movieapp.utils.PagedListUtil
import com.ghozadev.movieapp.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote, local)

    private val listMovies = DataDummy.generateDummyMovies()
    private val movie = listMovies[0]
    private val listTvShows = DataDummy.generateDummyTvShows()
    private val tvShow = listTvShows[0]

    @Test
    fun getPopularMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getListMovies()).thenReturn(dataSourceFactory)
        filmRepository.getPopularMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        Mockito.verify(local).getListMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovies.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        Mockito.`when`(local.getDetailMovie(movie.movieId)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getMovieDetail(movie.movieId))
        verify(local).getDetailMovie(movie.movieId)
        assertNotNull(movieEntities)
        assertEquals(movie.movieId, movieEntities.id)
        assertEquals(movie.title, movieEntities.title)
        assertEquals(movie.releaseDate, movieEntities.releaseDate)
        assertEquals(movie.posterPath, movieEntities.posterPath)
        assertEquals(movie.description, movieEntities.description)
    }

    @Test
    fun getPopularTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        Mockito.`when`(local.getListTvShows()).thenReturn(dataSourceFactory)
        filmRepository.getPopularTvShow()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        Mockito.verify(local).getListTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShows.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        Mockito.`when`(local.getDetailTvShow(tvShow.tvShowId)).thenReturn(dummyTvShow)

        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getTvShowDetail(tvShow.tvShowId))
        verify(local).getDetailTvShow(tvShow.tvShowId)
        assertNotNull(tvShowEntities)
        assertEquals(tvShow.tvShowId, tvShowEntities.id)
        assertEquals(tvShow.title, tvShowEntities.title)
        assertEquals(tvShow.releaseDate, tvShowEntities.releaseDate)
        assertEquals(tvShow.posterPath, tvShowEntities.posterPath)
        assertEquals(tvShow.description, tvShowEntities.description)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        Mockito.verify(local).getFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovies.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        Mockito.`when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteTvShows()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        Mockito.verify(local).getFavoriteTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShows.size.toLong(), tvShowEntity.data?.size?.toLong())
    }
}