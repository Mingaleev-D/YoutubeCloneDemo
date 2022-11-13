package com.example.youtubeclonedemo.data.model

data class VideoDetails(
   val publishedAt: String,
   val title: String,
   val thumbnails: Thumbnails,
   val channelTitle: String
)
