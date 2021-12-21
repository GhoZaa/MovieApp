package com.ghozadev.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.local.entity.VideoEntity
import com.ghozadev.movieapp.vo.Resource
import javax.inject.Inject

class DetailFilmViewModel @Inject constructor(private val filmRepository: FilmRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<MovieEntity> = filmRepository.getMovieDetail(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity> = filmRepository.getTvShowDetail(tvShowId)

    fun getMovieVideos(filmId: Int?): LiveData<Resource<PagedList<VideoEntity>>> =
        filmRepository.getMovieVideos(filmId)

    fun setFavoriteMovie(movie: MovieEntity) {
        filmRepository.setFavoriteMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        filmRepository.setFavoriteTvShow(tvShow)
    }
}