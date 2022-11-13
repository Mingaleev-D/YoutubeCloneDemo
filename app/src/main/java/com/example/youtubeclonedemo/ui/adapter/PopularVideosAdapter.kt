package com.example.youtubeclonedemo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeclonedemo.R
import com.example.youtubeclonedemo.data.model.YoutubeVideos
import com.example.youtubeclonedemo.databinding.ItemVideoBinding

/**
 * @author : Mingaleev D
 * @data : 13/11/2022
 */

class PopularVideosAdapter : RecyclerView.Adapter<PopularVideosAdapter.MyViewHolder>() {


   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemPopularVideosBinding = ItemVideoBinding.inflate(
         LayoutInflater.from(parent.context), parent, false
      )
      return MyViewHolder(itemPopularVideosBinding)
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val video = differ.currentList[position]
      val thumbnailUrl = video.snippet.thumbnails.medium.url
      val channelLogo = video.snippet.thumbnails.medium.url
      val title = video.snippet.title
      val channel = video.snippet.channelTitle
      val videoViews = video.statistics.viewCount
      val publishedAt = video.snippet.publishedAt

      holder.binding.apply {
         videoThumbnail.load(thumbnailUrl)
         channelPicture.load(channelLogo)
         videoTitle.text = title
         channelName.text = channel
         views.text = videoViews
         publishedTime.text = publishedAt
      }
   }

   override fun getItemCount(): Int = differ.currentList.size

   inner class MyViewHolder(val binding: ItemVideoBinding) :
      RecyclerView.ViewHolder(binding.root)

   private val differCallBack = object : DiffUtil.ItemCallback<YoutubeVideos>() {
      override fun areItemsTheSame(oldItem: YoutubeVideos, newItem: YoutubeVideos): Boolean =
         oldItem.id == newItem.id

      override fun areContentsTheSame(oldItem: YoutubeVideos, newItem: YoutubeVideos): Boolean =
         oldItem == newItem

   }
   val differ = AsyncListDiffer(this, differCallBack)
}

