package com.example.youtubeclonedemo.data.api

import com.example.youtubeclonedemo.data.model.YoutubeResponse
import com.example.youtubeclonedemo.util.Constants.API_KEY
import com.example.youtubeclonedemo.util.Constants.DETAILS
import com.example.youtubeclonedemo.util.Constants.LIST_OF_VIDEOS
import com.example.youtubeclonedemo.util.Constants.MOST_POPULAR
import com.example.youtubeclonedemo.util.Constants.REGION_CODE
import com.example.youtubeclonedemo.util.Constants.SNIPPET
import com.example.youtubeclonedemo.util.Constants.STATISTICS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 13/11/2022
 */

interface YoutubeApi {

   @GET(LIST_OF_VIDEOS)
   suspend fun fetchVideos(
      @Query("part") part: String = "$SNIPPET,$DETAILS,$STATISTICS",
      @Query("chart") chart: String = MOST_POPULAR,
      @Query("regionCode") regionCode: String = REGION_CODE,
      @Query("key") key: String = API_KEY
   ): Response<YoutubeResponse>
}