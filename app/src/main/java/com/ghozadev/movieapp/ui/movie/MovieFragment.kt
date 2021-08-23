package com.ghozadev.movieapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.databinding.FragmentMovieBinding
import com.ghozadev.movieapp.viewmodel.ViewModelFactory

class MovieFragment : Fragment(), FilmFragmentCallback {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
       return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val filmAdapter = FilmAdapter(this)

            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                fragmentMovieBinding.progressBar.visibility = View.GONE
                filmAdapter.setFilms(movies)
                filmAdapter.notifyDataSetChanged()
            })

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = filmAdapter
            }
        }
    }

    override fun onShareClick(film: FilmEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Share this application now")
                    .setText(resources.getString(R.string.share_text, film.title))
                    .startChooser()
        }
    }

}