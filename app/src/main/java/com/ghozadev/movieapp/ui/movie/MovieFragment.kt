package com.ghozadev.movieapp.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.databinding.FragmentMovieBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity.Companion.TYPE_MOVIE
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import com.ghozadev.movieapp.vo.Status
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieFragment : DaggerFragment(), MovieFragmentCallback {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var movieViewModel: MovieViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentMovieBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = MovieAdapter(this@MovieFragment)
        }

        activity?.let {
            movieViewModel = ViewModelProvider(it, factory)[MovieViewModel::class.java]
        }

        loadPopularFilm()

        val searchMovie = fragmentMovieBinding.searchMovie
        searchMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
                movieViewModel.getSearchMovie(query).observe(viewLifecycleOwner, { movies ->
                    if (movies != null) {
                        when (movies.status) {
                            Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                fragmentMovieBinding.progressBar.visibility = View.GONE
                                fragmentMovieBinding.rvMovie.adapter?.let { adapter ->
                                    when (adapter) {
                                        is MovieAdapter -> {
                                            adapter.submitList(movies.data)
                                            adapter.notifyDataSetChanged()
                                        }
                                    }
                                }
                            }
                            Status.ERROR -> {
                                fragmentMovieBinding.progressBar.visibility = View.GONE
                                Toast.makeText(context, "Error connection to internet", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                loadPopularFilm()
                return true
            }
        })

    }

    override fun onShareClick(data: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Share this film now!")
                    .setText(resources.getString(R.string.share_text, data.title))
                    .startChooser()
        }
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(
            Intent(context, DetailFilmActivity::class.java)
                .putExtra(DetailFilmActivity.EXTRA_FILM, data.movieId)
                .putExtra(DetailFilmActivity.EXTRA_TYPE, TYPE_MOVIE)
        )
    }

    private fun loadPopularFilm() {
        movieViewModel.getMovies().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        fragmentMovieBinding.rvMovie.adapter?.let { adapter ->
                            when (adapter) {
                                is MovieAdapter -> {
                                    adapter.submitList(movies.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Error connection to internet", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

}