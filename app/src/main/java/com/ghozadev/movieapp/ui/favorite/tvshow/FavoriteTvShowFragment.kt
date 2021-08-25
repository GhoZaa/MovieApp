package com.ghozadev.movieapp.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghozadev.movieapp.databinding.FragmentFavoriteTvShowBinding

class FavoriteTvShowFragment : Fragment() {

    private var _fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _fragmentFavoriteTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteTvShowBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}