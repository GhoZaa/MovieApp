package com.ghozadev.movieapp.di

import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource

object Injection {

    fun provideFilmRepository(): FilmRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return FilmRepository.getInstance(remoteDataSource)
    }
}