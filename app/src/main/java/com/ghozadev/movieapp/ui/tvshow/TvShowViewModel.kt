package com.ghozadev.movieapp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.vo.Resource
import javax.inject.Inject

class TvShowViewModel @Inject constructor(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getPopularTvShow()

    fun getSearchTvShow(title : String): LiveData<Resource<PagedList<TvShowEntity>>> =
        filmRepository.getSearchTvShow(title)
}