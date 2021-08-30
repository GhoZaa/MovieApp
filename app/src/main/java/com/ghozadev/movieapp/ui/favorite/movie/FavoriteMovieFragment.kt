package com.ghozadev.movieapp.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.databinding.FragmentFavoriteMovieBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.favorite.FavoriteViewModel
import com.ghozadev.movieapp.ui.movie.MovieAdapter
import com.ghozadev.movieapp.ui.movie.MovieFragmentCallback
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteMovieFragment : DaggerFragment(), MovieFragmentCallback {

    private var _fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _fragmentFavoriteMovieBinding

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.rvFavoriteMovie) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.setHasFixedSize(true)
            this?.adapter = MovieAdapter(this@FavoriteMovieFragment)
        }

        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }

        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                binding?.rvFavoriteMovie?.adapter?.let { adapter ->
                    when (adapter) {
                        is MovieAdapter -> {
                            if (movies.isNullOrEmpty()){
                                binding?.rvFavoriteMovie?.visibility = View.GONE
                                binding?.favoriteEmptyLayout?.imgEmptyList?.visibility = View.VISIBLE
                            } else {
                                binding?.rvFavoriteMovie?.visibility = View.VISIBLE
                                adapter.submitList(movies)
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        })
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(
            Intent(context, DetailFilmActivity::class.java)
                .putExtra(DetailFilmActivity.EXTRA_FILM, data.movieId)
                .putExtra(DetailFilmActivity.EXTRA_TYPE, DetailFilmActivity.TYPE_MOVIE)
        )
    }

    override fun onShareClick(data: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share this application now")
                .setText(resources.getString(R.string.share_text, data.title))
                .startChooser()
        }
    }

}