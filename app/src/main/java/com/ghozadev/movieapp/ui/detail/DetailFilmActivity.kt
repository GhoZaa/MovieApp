package com.ghozadev.movieapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.databinding.ActivityDetailFilmBinding
import com.ghozadev.movieapp.databinding.ContentDetailFilmBinding
import com.ghozadev.movieapp.ui.favorite.FavoriteActivity
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailFilmActivity : DaggerAppCompatActivity() {

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

        with(detailContentBinding) {
            textTitle.text = movieEntity?.title ?: tvShowEntity?.title
            textDescription.text = movieEntity?.description ?: tvShowEntity?.description
            textReleaseDate.text = movieEntity?.releaseDate ?: tvShowEntity?.releaseDate

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

}