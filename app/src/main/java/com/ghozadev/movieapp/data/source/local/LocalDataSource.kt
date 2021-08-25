package com.ghozadev.movieapp.data.source.local

import androidx.lifecycle.LiveData
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    fun getListMovies() : LiveData<List<MovieEntity>> = mFilmDao.getListMovies()

    fun getListFavoriteMovies() : LiveData<List<MovieEntity>> = mFilmDao.getListFavoriteMovies()

    fun getListTvShows() : LiveData<List<TvShowEntity>> = mFilmDao.getListTvShows()

    fun getListFavoriteTvShows() : LiveData<List<TvShowEntity>> = mFilmDao.getListFavoriteTvShows()

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