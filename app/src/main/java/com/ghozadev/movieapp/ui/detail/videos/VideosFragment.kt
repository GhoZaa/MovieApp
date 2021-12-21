package com.ghozadev.movieapp.ui.detail.videos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghozadev.movieapp.data.source.local.entity.VideoEntity
import com.ghozadev.movieapp.databinding.FragmentVideosBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity.Companion.EXTRA_FILM
import com.ghozadev.movieapp.ui.detail.DetailFilmCallback
import com.ghozadev.movieapp.ui.detail.DetailFilmViewModel
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import com.ghozadev.movieapp.vo.Status
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class VideosFragment : DaggerFragment(), DetailFilmCallback {
    private lateinit var fragmentVideoBinding: FragmentVideosBinding
    private lateinit var viewModel: DetailFilmViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentVideoBinding = FragmentVideosBinding.inflate(layoutInflater, container, false)
        return fragmentVideoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentVideoBinding.rvMovieVideo) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = VideoAdapter(this@VideosFragment)
        }

        activity?.let {
            viewModel = ViewModelProvider(it, factory)[DetailFilmViewModel::class.java]
        }

        val filmId = requireActivity().intent.getIntExtra(EXTRA_FILM, 0)
        viewModel.getMovieVideos(filmId).observe(viewLifecycleOwner, { videoMovies ->
            if (videoMovies != null) {
                when (videoMovies.status) {
//                        Status.LOADING -> detailContentBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
//                            detailContentBinding.progressBar.visibility = View.GONE
                        fragmentVideoBinding.rvMovieVideo.adapter?.let { adapter ->
                            when (adapter) {
                                is VideoAdapter -> {
                                    adapter.submitList(videoMovies.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
//                            detailContentBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Error connection to internet", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    override fun onItemClicked(data: VideoEntity) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=${data.key}"))
        startActivity(intent)
    }

}