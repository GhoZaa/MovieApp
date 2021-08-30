package com.ghozadev.movieapp.di.home

import com.ghozadev.movieapp.di.home.favorite.FavoriteFragmentBuildersModule
import com.ghozadev.movieapp.ui.favorite.FavoriteActivity
import com.ghozadev.movieapp.ui.movie.MovieFragment
import com.ghozadev.movieapp.ui.tvshow.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment() : MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment() : TvShowFragment

}