package com.ghozadev.movieapp.di

import com.ghozadev.movieapp.di.detail.DetailFragmentBuildersModule
import com.ghozadev.movieapp.di.home.HomeFragmentBuildersModule
import com.ghozadev.movieapp.di.home.favorite.FavoriteFragmentBuildersModule
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.favorite.FavoriteActivity
import com.ghozadev.movieapp.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [DetailFragmentBuildersModule::class])
    abstract fun contributeDetailFilmActivity(): DetailFilmActivity

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteActivity(): FavoriteActivity
}