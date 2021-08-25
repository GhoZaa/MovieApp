package com.ghozadev.movieapp.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ghozadev.movieapp.databinding.FragmentFavoriteMovieBinding

class FavoriteMovieFragment : Fragment() {

    private var _fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _fragmentFavoriteMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}