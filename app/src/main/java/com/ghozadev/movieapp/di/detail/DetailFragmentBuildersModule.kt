package com.ghozadev.movieapp.di.detail

import com.ghozadev.movieapp.ui.detail.videos.VideosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeVideosFragment() : VideosFragment
}