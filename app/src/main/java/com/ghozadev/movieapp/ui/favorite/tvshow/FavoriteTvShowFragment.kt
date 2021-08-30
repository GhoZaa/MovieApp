package com.ghozadev.movieapp.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.databinding.FragmentFavoriteTvShowBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.favorite.FavoriteViewModel
import com.ghozadev.movieapp.ui.tvshow.TvShowAdapter
import com.ghozadev.movieapp.ui.tvshow.TvShowFragmentCallback
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteTvShowFragment : DaggerFragment(), TvShowFragmentCallback {

    private lateinit var fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding
//    private val binding get() = _fragmentFavoriteTvShowBinding

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteTvShowBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentFavoriteTvShowBinding.rvFavoriteTvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = TvShowAdapter(this@FavoriteTvShowFragment)
        }

        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[FavoriteViewModel::class.java]
        }

        viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShows ->
            if (tvShows != null) {
                fragmentFavoriteTvShowBinding.rvFavoriteTvShow.adapter?.let { adapter ->
                    when (adapter) {
                        is TvShowAdapter -> {
                            if (tvShows.isNullOrEmpty()){
                                fragmentFavoriteTvShowBinding.rvFavoriteTvShow.visibility = View.GONE
                                fragmentFavoriteTvShowBinding.favoriteEmptyState.imgEmptyList.visibility = View.VISIBLE
                            } else {
                                fragmentFavoriteTvShowBinding.rvFavoriteTvShow.visibility = View.VISIBLE
                                adapter.submitList(tvShows)
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }
        })
    }

    override fun onItemClicked(data: TvShowEntity) {
        startActivity(
            Intent(context, DetailFilmActivity::class.java)
                .putExtra(DetailFilmActivity.EXTRA_FILM, data.tvShowId)
                .putExtra(DetailFilmActivity.EXTRA_TYPE, DetailFilmActivity.TYPE_TV_SHOW)
        )
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
}