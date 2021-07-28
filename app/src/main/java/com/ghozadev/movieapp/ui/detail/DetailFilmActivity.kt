package com.ghozadev.movieapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.FilmEntity
import com.ghozadev.movieapp.databinding.ActivityDetailFilmBinding
import com.ghozadev.movieapp.databinding.ContentDetailFilmBinding

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_film"
    }

    private lateinit var detailContentBinding: ContentDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailFilmBinding.detailContent

        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val titleFilm = extras.getString(EXTRA_FILM)
            if (titleFilm != null) {
                viewModel.setSelectedFilm(titleFilm)
                populateFilm(viewModel.getFilm() as FilmEntity)
            }
        }
    }

    private fun populateFilm(filmEntity: FilmEntity) {
        detailContentBinding.textTitle.text = filmEntity.title
        detailContentBinding.textDescription.text = filmEntity.description
        detailContentBinding.textReleaseDate.text = filmEntity.releaseDate

        Glide.with(this)
            .load(filmEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)


    }

}