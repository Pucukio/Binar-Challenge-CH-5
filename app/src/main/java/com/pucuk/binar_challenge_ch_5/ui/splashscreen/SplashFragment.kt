package com.pucuk.binar_challenge_ch_5.ui.splashscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pucuk.binar_challenge_ch_5.R
import com.pucuk.binar_challenge_ch_5.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel
    lateinit var _binding: FragmentSplashBinding
    val splashVM: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            splashVM.currentUser(findNavController())
        }, 3000)
    }

}