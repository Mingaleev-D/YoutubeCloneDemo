package com.example.youtubeclonedemo.util

//https://youtube.googleapis.com/youtube/v3/videos?part=snippet,contentDetails,statistics&chart=mostPopular&regionCode=RU&key=AIzaSyDdKgTrylnVs21SI9vVhFAYSRFKLlMvcHA

object Constants {
   const val BASE_URL = "https://youtube.googleapis.com/youtube/v3/"

   //Эта конечная точка получает список видео
   const val LIST_OF_VIDEOS = "videos"

   //Эта конечная точка получает информацию о канале, например, логотип канала, количество подписчиков.
   const val CHANNEL_INFO = "channels"

   //PART PROPERTIES
   const val SNIPPET = "snippet"
   const val DETAILS = "contentDetails"
   const val STATISTICS = "statistics"

   //CHART PROPERTY
   const val MOST_POPULAR = "mostPopular"

   //REGION_CODE
   const val REGION_CODE = "RU"

   const val API_KEY = "AIzaSyDdKgTrylnVs21SI9vVhFAYSRFKLlMvcHA"
}