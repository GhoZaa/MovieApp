package com.ghozadev.movieapp.di.home.favorite

import com.ghozadev.movieapp.ui.favorite.movie.FavoriteMovieFragment
import com.ghozadev.movieapp.ui.favorite.tvshow.FavoriteTvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment() : FavoriteMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment() : FavoriteTvShowFragment
}