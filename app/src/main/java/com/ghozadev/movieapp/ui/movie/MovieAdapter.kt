package com.ghozadev.movieapp.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.databinding.ItemsFilmBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity

class MovieAdapter(private val callback: MovieFragmentCallback) :
    PagedListAdapter<MovieEntity, MovieAdapter.FilmViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemsFilmBinding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemsFilmBinding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }

    inner class FilmViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = itemView.resources.getString(R.string.release_date, movie.releaseDate)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_FILM, movie.id)
                    callback.onItemClicked(movie)
                }
                imgShare.setOnClickListener { callback.onShareClick(movie) }
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w185/" + movie.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}