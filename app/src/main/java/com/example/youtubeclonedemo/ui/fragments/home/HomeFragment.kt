package com.example.youtubeclonedemo.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeclonedemo.R
import com.example.youtubeclonedemo.databinding.FragmentHomeBinding
import com.example.youtubeclonedemo.ui.adapter.PopularVideosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

   private var mBinding: FragmentHomeBinding? = null
   private val binding get() = mBinding!!
   private lateinit var adapterPopVid: PopularVideosAdapter
   private val viewModel: HomePopularVideoViewModel by viewModels()

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentHomeBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      hideActionBar()
      setUpRecyclerView()
      observeDataFromYoutubeApi()
   }

   private fun observeDataFromYoutubeApi() {
      viewModel.popularVideos.observe(viewLifecycleOwner){result ->
         adapterPopVid.differ.submitList(result.data?.items)
      }
   }

   private fun setUpRecyclerView() {
      adapterPopVid = PopularVideosAdapter()
      binding.videosRecyclerview.apply {
         adapter = adapterPopVid
         layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
      }
   }

   private fun hideActionBar() {
      (activity as AppCompatActivity).supportActionBar?.hide()
   }

   override fun onDestroyView() {
      super.onDestroyView()
      mBinding = null
   }


}