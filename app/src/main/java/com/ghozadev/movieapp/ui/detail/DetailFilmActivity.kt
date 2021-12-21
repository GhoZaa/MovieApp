package com.ghozadev.movieapp.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.data.source.local.entity.VideoEntity
import com.ghozadev.movieapp.databinding.ActivityDetailFilmBinding
import com.ghozadev.movieapp.databinding.ContentDetailFilmBinding
import com.ghozadev.movieapp.ui.detail.videos.VideoAdapter
import com.ghozadev.movieapp.ui.favorite.FavoriteActivity
import com.ghozadev.movieapp.ui.movie.MovieAdapter
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import com.ghozadev.movieapp.vo.Status
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailFilmActivity : DaggerAppCompatActivity(), DetailFilmCallback {

    private lateinit var detailContentBinding: ContentDetailFilmBinding
    private lateinit var viewModel: DetailFilmViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailFilmBinding.detailContent

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this@DetailFilmActivity, factory)[DetailFilmViewModel::class.java]

        val extras = intent.extras
        activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
        if (extras != null) {
            val filmId = extras.getInt(EXTRA_FILM, 0)
            val type = extras.getString(EXTRA_TYPE)

            if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
                activityDetailFilmBinding.progressBar.visibility = View.GONE
                viewModel.getDetailMovie(filmId).observe(this, { film ->
                    populateFilm(film, null)
                })

            } else if (type.equals(TYPE_TV_SHOW, ignoreCase = true)) {
                activityDetailFilmBinding.progressBar.visibility = View.GONE
                viewModel.getDetailTvShow(filmId).observe(this, { film ->
                    populateFilm(null, film)
                })
            }
        }
    }

    private fun populateFilm(movieEntity: MovieEntity?, tvShowEntity: TvShowEntity?) {
        val posterPath = movieEntity?.posterPath ?: tvShowEntity?.posterPath
        val favoriteStatus = movieEntity?.isFavorite ?: tvShowEntity?.isFavorite
        val filmId = movieEntity?.movieId ?: tvShowEntity?.tvShowId
        val uriStr =
            if (movieEntity != null) "https://www.themoviedb.org/movie/$filmId"
            else "https://www.themoviedb.org/tv/$filmId"

        with(detailContentBinding) {
            textTitle.text = movieEntity?.title ?: tvShowEntity?.title
            textDescription.text = movieEntity?.description ?: tvShowEntity?.description
            textReleaseDate.text = movieEntity?.releaseDate ?: tvShowEntity?.releaseDate

            viewModel.getMovieVideos(filmId).observe(this@DetailFilmActivity, { videoMovies ->
                if (videoMovies != null) {
                    when (videoMovies.status) {
                        Status.LOADING -> detailContentBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            detailContentBinding.progressBar.visibility = View.GONE
                            detailContentBinding.rvMovieVideo.adapter?.let { adapter ->
                                when (adapter) {
                                    is VideoAdapter -> {
                                        adapter.submitList(videoMovies.data)
                                        adapter.notifyDataSetChanged()
                                    }
                                }
                            }
                        }
                        Status.ERROR -> {
                            detailContentBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Error connection to internet", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            btnViewOnTmdb.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(uriStr)
                startActivity(intent)
            }

            Glide.with(this@DetailFilmActivity)
                .load("https://image.tmdb.org/t/p/w185/$posterPath")
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster)
        }

        favoriteStatus?.let { status ->
            if (status) {
                detailContentBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_24)
            } else {
                detailContentBinding.fabFavorite.setImageResource(R.drawable.ic_unfavorite_24)
            }
        }

        detailContentBinding.fabFavorite.setOnClickListener {
            setFavorite(movieEntity, tvShowEntity)
        }
    }

    private fun setFavorite(movieEntity: MovieEntity?, tvShowEntity: TvShowEntity?) {
        if (movieEntity != null) {
            if (movieEntity.isFavorite){
                showSnackBar("${movieEntity.title} removed from favorite list")
            }else {
                showSnackBar("${movieEntity.title} added to favorite list")
            }
            viewModel.setFavoriteMovie(movieEntity)
        } else {
            if (tvShowEntity != null) {
                if (tvShowEntity.isFavorite){
                    showSnackBar("${tvShowEntity.title} removed from favorite list")
                }else {
                    showSnackBar("${tvShowEntity.title} added to favorite list")
                }
                viewModel.setFavoriteTvShow(tvShowEntity)
            }
        }
    }

    private fun showSnackBar(msg: String) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT)
            .setAction("View") {
                val mIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mIntent)
            }
            .show()
    }

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
        const val TYPE_MOVIE = "TYPE_MOVIE"
        const val TYPE_TV_SHOW = "TYPE_TV_SHOW"
    }

    override fun onItemClicked(data: VideoEntity) {
        val intent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=${data.key}"))
        startActivity(intent)
    }

}