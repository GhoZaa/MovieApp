package com.ghozadev.movieapp.ui.detail.videos

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ghozadev.movieapp.data.source.local.entity.MovieEntity
import com.ghozadev.movieapp.data.source.local.entity.VideoEntity
import com.ghozadev.movieapp.databinding.ItemsVideoBinding
import com.ghozadev.movieapp.ui.detail.DetailFilmActivity
import com.ghozadev.movieapp.ui.detail.DetailFilmCallback
import com.ghozadev.movieapp.ui.movie.MovieAdapter
import kotlinx.coroutines.withContext

class VideoAdapter(private val callback: DetailFilmCallback) :
    PagedListAdapter<VideoEntity, VideoAdapter.VideoViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemsVideoBinding = ItemsVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(itemsVideoBinding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }

    inner class VideoViewHolder(private val binding: ItemsVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(videoEntity: VideoEntity) {
            with(binding) {
                tvItemType.text = videoEntity.type
                tvItemName.text = videoEntity.name
                itemView.setOnClickListener {
                    callback.onItemClicked(videoEntity)
                }
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<VideoEntity>() {
            override fun areItemsTheSame(oldItem: VideoEntity, newItem: VideoEntity): Boolean {
                return oldItem.filmId == newItem.filmId
            }
            override fun areContentsTheSame(oldItem: VideoEntity, newItem: VideoEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}