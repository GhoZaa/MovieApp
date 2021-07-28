package com.ghozadev.movieapp.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.databinding.FragmentTvShowBinding
import com.ghozadev.movieapp.ui.movie.FilmAdapter
import com.ghozadev.movieapp.ui.movie.FilmFragmentCallback
import com.ghozadev.movieapp.utils.DataDummy

/**
 * A simple [Fragment] subclass.
 * Use the [TvShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TvShowFragment : Fragment(), FilmFragmentCallback {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val films = viewModel.getTvShow()

            val filmAdapter = FilmAdapter(this)
            filmAdapter.setFilms(films)

            with(fragmentTvShowBinding.rvTvShow) {
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