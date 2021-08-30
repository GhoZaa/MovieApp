package com.ghozadev.movieapp.di

import com.ghozadev.movieapp.di.home.HomeFragmentBuildersModule
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailFilmActivity(): DetailFilmActivity
}