package com.ghozadev.movieapp.ui.tvshow

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
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.databinding.FragmentTvShowBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.movie.MovieAdapter
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import com.ghozadev.movieapp.vo.Status
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TvShowFragment : DaggerFragment(), TvShowFragmentCallback {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var tvShowViewModel: TvShowViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentTvShowBinding.rvTvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = TvShowAdapter(this@TvShowFragment)
        }

        activity?.let {
            tvShowViewModel = ViewModelProvider(it, factory)[TvShowViewModel::class.java]
        }

        loadPopularTvShows()

        fragmentTvShowBinding.searchTvShow.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(context, query, Toast.LENGTH_SHORT).show()
                tvShowViewModel.getSearchTvShow(query).observe(viewLifecycleOwner, { tvShows ->
                    if (tvShows != null) {
                        when (tvShows.status) {
                            Status.LOADING -> fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                fragmentTvShowBinding.progressBar.visibility = View.GONE
                                fragmentTvShowBinding.rvTvShow.adapter?.let { adapter ->
                                    when (adapter) {
                                        is TvShowAdapter -> {
                                            adapter.submitList(tvShows.data)
                                            adapter.notifyDataSetChanged()
                                        }
                                    }
                                }
                            }
                            Status.ERROR -> {
                                fragmentTvShowBinding.progressBar.visibility = View.GONE
                                Toast.makeText(context, "Error connection to internet", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                loadPopularTvShows()
                return true
            }
        })
    }

    override fun onShareClick(data: TvShowEntity) {
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

    override fun onItemClicked(data: TvShowEntity) {
        startActivity(
            Intent(context, DetailFilmActivity::class.java)
                .putExtra(DetailFilmActivity.EXTRA_FILM, data.tvShowId)
                .putExtra(DetailFilmActivity.EXTRA_TYPE, DetailFilmActivity.TYPE_TV_SHOW)
        )
    }

    private fun loadPopularTvShows() {
        tvShowViewModel.getTvShow().observe(viewLifecycleOwner, { tvShows ->
            if (tvShows != null) {
                when (tvShows.status) {
                    Status.LOADING -> fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentTvShowBinding.progressBar.visibility = View.GONE
                        fragmentTvShowBinding.rvTvShow.adapter?.let { adapter ->
                            when (adapter) {
                                is TvShowAdapter -> {
                                    adapter.submitList(tvShows.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        fragmentTvShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Error connection to internet", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

}