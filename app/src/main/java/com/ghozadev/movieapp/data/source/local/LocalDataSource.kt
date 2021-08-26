package com.ghozadev.movieapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    fun getListMovies() : DataSource.Factory<Int, MovieEntity> = mFilmDao.getListMovies()

    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = mFilmDao.getListFavoriteMovies()

    fun getListTvShows() : DataSource.Factory<Int, TvShowEntity> = mFilmDao.getListTvShows()

    fun getFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = mFilmDao.getListFavoriteTvShows()

    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity> = mFilmDao.getDetailMovieById(movieId)

    fun getDetailTvShow(tvShowId: Int) : LiveData<TvShowEntity> = mFilmDao.getDetailTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mFilmDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie : MovieEntity) {
        movie.isFavorite = !movie.isFavorite
        mFilmDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow : TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        mFilmDao.updateTvShow(tvShow)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao).apply {
                INSTANCE = this
            }
    }
}