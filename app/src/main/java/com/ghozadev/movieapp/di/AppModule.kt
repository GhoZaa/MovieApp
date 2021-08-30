package com.ghozadev.movieapp.di

import android.app.Application
import com.ghozadev.movieapp.data.FilmRepository
import com.ghozadev.movieapp.data.source.local.LocalDataSource
import com.ghozadev.movieapp.data.source.local.room.FilmDao
import com.ghozadev.movieapp.data.source.local.room.FilmDatabase
import com.ghozadev.movieapp.data.source.remote.RemoteDataSource
import com.ghozadev.movieapp.data.source.remote.api.ApiService
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideFilmDatabase(application: Application): FilmDatabase =
            FilmDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideFilmDao(filmDatabase: FilmDatabase): FilmDao =
            filmDatabase.filmDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(filmDao: FilmDao): LocalDataSource =
            LocalDataSource(filmDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideFilmRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ): FilmRepository = FilmRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(filmRepository: FilmRepository): ViewModelFactory =
            ViewModelFactory(filmRepository)

    }
}