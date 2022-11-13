package com.example.youtubeclonedemo.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeclonedemo.data.model.YoutubeResponse
import com.example.youtubeclonedemo.repository.FetchPopularRepository
import com.example.youtubeclonedemo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 13/11/2022
 */
@HiltViewModel
class HomePopularVideoViewModel @Inject constructor(
   private val repository: FetchPopularRepository
) : ViewModel() {

   private val _popularVideos: MutableLiveData<Resource<YoutubeResponse>> = MutableLiveData()
   var popularVideos: LiveData<Resource<YoutubeResponse>> = _popularVideos

   private fun fetchPopularVideos() = viewModelScope.launch {
      _popularVideos.postValue(Resource.Loading())
      val response = repository.getPopularVideos()
      _popularVideos.postValue(handleYoutubeResponse(response))
   }

   private fun handleYoutubeResponse(response: Response<YoutubeResponse>): Resource<YoutubeResponse>? {
      if (response.isSuccessful) {
         response.body()?.let { youtuberesponse ->
            return Resource.Success(youtuberesponse)
         }
      }
      return Resource.Error(response.message())
   }
}