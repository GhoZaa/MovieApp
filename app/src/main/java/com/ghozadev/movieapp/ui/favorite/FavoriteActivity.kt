package com.ghozadev.movieapp.ui.favorite

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ghozadev.movieapp.databinding.ActivityFavoriteBinding
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class FavoriteActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        supportActionBar?.title = "Favorite Films"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = sectionsPagerAdapter
        activityFavoriteBinding.favoriteTabs.setupWithViewPager(activityFavoriteBinding.viewPager)

        viewModel = ViewModelProvider(this@FavoriteActivity, factory)[FavoriteViewModel::class.java]

        supportActionBar?.elevation = 0f
    }
}