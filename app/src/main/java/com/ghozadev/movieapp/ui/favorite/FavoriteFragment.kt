package com.ghozadev.movieapp.ui.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ghozadev.movieapp.databinding.FragmentFavoriteBinding
import com.ghozadev.movieapp.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteFragment : DaggerFragment() {

    private lateinit var fragmentFavoriteBinding: FragmentFavoriteBinding

    private lateinit var viewModel: FavoriteViewModel

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let { setupViewPager(it) }
        viewModel = ViewModelProvider(this@FavoriteFragment, factory)[FavoriteViewModel::class.java]
    }

    private fun setupViewPager(context: Context) {
        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(context, childFragmentManager)
        fragmentFavoriteBinding.viewPager.adapter = sectionsPagerAdapter
        fragmentFavoriteBinding.favoriteTabs.setupWithViewPager(fragmentFavoriteBinding.viewPager)
    }


}