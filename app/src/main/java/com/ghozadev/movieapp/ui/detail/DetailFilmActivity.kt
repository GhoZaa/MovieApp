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

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailContentBinding: ContentDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailFilmBinding.detailContent

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        val extras = intent.extras
        val type = intent.getStringExtra(EXTRA_TYPE)
        if (extras != null) {
            val filmId = extras.getInt(EXTRA_FILM)
            activityDetailFilmBinding.progressBar.visibility = View.GONE
            activityDetailFilmBinding.content.visibility = View.INVISIBLE

            viewModel.setSelectedFilm(filmId)
            viewModel.getMovie().observe(this, { film -> populateFilm(film) })
        }
    }

    private fun populateFilm(filmEntity: FilmEntity) {
        detailContentBinding.textTitle.text = filmEntity.title
        detailContentBinding.textDescription.text = filmEntity.description
        detailContentBinding.textReleaseDate.text = filmEntity.releaseDate

        Glide.with(this)
            .load(filmEntity.posterPath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

    }

}