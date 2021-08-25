package com.ghozadev.movieapp.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghozadev.movieapp.databinding.ActivityFavoriteBinding
import com.ghozadev.movieapp.ui.home.HomeActivity

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        supportActionBar?.title = "Favorite Films"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val favSectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = favSectionsPagerAdapter
        activityFavoriteBinding.favoriteTabs.setupWithViewPager(activityFavoriteBinding.viewPager)

        supportActionBar?.elevation = 0f
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        val mIntent = Intent(this, HomeActivity::class.java)
//        startActivity(mIntent)
//    }
}