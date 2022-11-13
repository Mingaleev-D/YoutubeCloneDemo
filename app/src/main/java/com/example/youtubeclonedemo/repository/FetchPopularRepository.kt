package com.example.youtubeclonedemo.repository

import com.example.youtubeclonedemo.data.api.YoutubeApi
import com.example.youtubeclonedemo.data.model.YoutubeResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 13/11/2022
 */

class FetchPopularRepository @Inject constructor(
   private val api: YoutubeApi
) {
   suspend fun getPopularVideos(): Response<YoutubeResponse> {
      return api.fetchVideos()
   }
}