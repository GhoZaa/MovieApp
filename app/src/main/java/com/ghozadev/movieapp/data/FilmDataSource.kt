package com.ghozadev.movieapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.local.entity.VideoEntity
import com.ghozadev.movieapp.vo.Resource

interface FilmDataSource {

    fun getPopularMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getSearchMovie(movieTitle: String): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieDetail(movieId: Int): LiveData<MovieEntity>

    fun getMovieVideos(movieId: Int?): LiveData<Resource<PagedList<VideoEntity>>>

    fun getPopularTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getSearchTvShow(tvShowTitle: String): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity)

    fun setFavoriteTvShow(tvShow: TvShowEntity)
}