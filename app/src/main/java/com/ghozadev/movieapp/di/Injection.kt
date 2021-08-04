package com.ghozadev.movieapp.di

import android.content.Context
import com.ghozadev.movieapp.data.source.remote.FilmRepository
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource

object Injection {

    fun provideFilmRepository(context: Context): FilmRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return FilmRepository.getInstance(remoteDataSource)
    }
}