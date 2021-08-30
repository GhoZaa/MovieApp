package com.ghozadev.movieapp.ui.tvshow

import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity

interface TvShowFragmentCallback {
    fun onShareClick(data: TvShowEntity)

    fun onItemClicked(data: TvShowEntity)
}