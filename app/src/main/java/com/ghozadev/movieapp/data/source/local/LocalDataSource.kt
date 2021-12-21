package com.ghozadev.movieapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.local.entity.VideoEntity
import com.ghozadev.movieapp.data.source.local.room.FilmDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val mFilmDao: FilmDao) {

    fun getListMovies() : DataSource.Factory<Int, MovieEntity> = mFilmDao.getListMovies()

    fun getListMovieSearch(movieTitle: String) : DataSource.Factory<Int, MovieEntity> = mFilmDao.getListMovieSearch(movieTitle)

    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = mFilmDao.getListFavoriteMovies()

    fun getMovieVideos(filmId: Int?) : DataSource.Factory<Int, VideoEntity> = mFilmDao.getMovieVideos(filmId)

    fun getListTvShows() : DataSource.Factory<Int, TvShowEntity> = mFilmDao.getListTvShows()

    fun getListTvShowSearch(tvShowTitle: String) : DataSource.Factory<Int, TvShowEntity> = mFilmDao.getListTvShowSearch(tvShowTitle)

    fun getFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = mFilmDao.getListFavoriteTvShows()

    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity> = mFilmDao.getDetailMovieById(movieId)

    fun getDetailTvShow(tvShowId: Int) : LiveData<TvShowEntity> = mFilmDao.getDetailTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertMovieVideos(movieVideos: List<VideoEntity>) = mFilmDao.insertMovieVideo(movieVideos)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mFilmDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie : MovieEntity) {
        movie.isFavorite = !movie.isFavorite
        mFilmDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow : TvShowEntity) {
        tvShow.isFavorite = !tvShow.isFavorite
        mFilmDao.updateTvShow(tvShow)
    }
}