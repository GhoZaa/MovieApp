package com.ghozadev.movieapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.databinding.ActivityDetailFilmBinding
import com.ghozadev.movieapp.databinding.ContentDetailFilmBinding
import com.ghozadev.movieapp.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailFilmBinding.detailContent

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        val extras = intent.extras

        activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
        if (extras != null) {
            val filmId = extras.getInt(EXTRA_FILM)
            val type = extras.getString(EXTRA_TYPE)

            if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
                activityDetailFilmBinding.progressBar.visibility = View.GONE
                viewModel.getMovie(filmId).observe(this, { film -> populateFilm(film) })
            } else if (type.equals(TYPE_TV_SHOW, ignoreCase = true)) {
                activityDetailFilmBinding.progressBar.visibility = View.GONE
                viewModel.getTvShow(filmId).observe(this, { film -> populateFilm(film) })
            }
        }
    }

    private fun populateFilm(filmEntity: FilmEntity) {
        with(detailContentBinding) {
            textTitle.text = filmEntity.title
            textDescription.text = filmEntity.description
            textReleaseDate.text = filmEntity.releaseDate

            Glide.with(this@DetailFilmActivity)
                .load("https://image.tmdb.org/t/p/w185/" + filmEntity.posterPath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster)
        }
    }

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
        const val TYPE_MOVIE = "TYPE_MOVIE"
        const val TYPE_TV_SHOW = "TYPE_TV_SHOW"
    }

}