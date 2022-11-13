package com.example.youtubeclonedemo.di

import com.example.youtubeclonedemo.data.api.YoutubeApi
import com.example.youtubeclonedemo.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   @Provides
   @Singleton
   fun provideRetrofit(): Retrofit =
      Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .client(loggingInterceptor())
         .build()

   private fun loggingInterceptor(): OkHttpClient {
      val loggingInterceptor = HttpLoggingInterceptor()
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
      return OkHttpClient.Builder()
         .addInterceptor(loggingInterceptor)
         .build()
   }

   @Provides
   @Singleton
   fun provideYoutubeApi(retrofit: Retrofit): YoutubeApi =
      retrofit.create(YoutubeApi::class.java)
}