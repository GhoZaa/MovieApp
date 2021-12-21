package com.ghozadev.movieapp.ui.detail

import com.ghozadev.movieapp.data.source.local.entity.VideoEntity

interface DetailFilmCallback {

    fun onItemClicked(data: VideoEntity)
}