package com.example.youtubeclonedemo.ui.fragments.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.youtubeclonedemo.R
import com.example.youtubeclonedemo.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

   private var mBinding: FragmentSplashScreenBinding? = null
   private val binding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentSplashScreenBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      hideActionBar()
      navigateToHomeScreen()
   }

   private fun navigateToHomeScreen() {
      Handler(Looper.getMainLooper()).postDelayed({
         findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
      }, 2_000)
   }

   private fun hideActionBar() {
      (activity as AppCompatActivity).supportActionBar?.hide()
   }

   override fun onDestroyView() {
      super.onDestroyView()
      mBinding = null
   }


}