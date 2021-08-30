package com.ghozadev.movieapp.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ghozadev.movieapp.R
import com.ghozadev.movieapp.data.source.local.entity.TvShowEntity
import com.ghozadev.movieapp.databinding.ItemsFilmBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity

class TvShowAdapter(private val callback: TvShowFragmentCallback) :
    PagedListAdapter<TvShowEntity, TvShowAdapter.FilmViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.FilmViewHolder {
        val itemsFilmBinding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemsFilmBinding)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.FilmViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) holder.bind(tvShow)
    }

    inner class FilmViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDate.text = itemView.resources.getString(R.string.release_date, tvShow.releaseDate)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_FILM, tvShow.id)
                    callback.onItemClicked(tvShow)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvShow) }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185/" + tvShow.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}