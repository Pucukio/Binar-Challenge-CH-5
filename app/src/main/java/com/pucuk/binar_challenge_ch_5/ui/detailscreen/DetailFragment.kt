package com.pucuk.binar_challenge_ch_5.ui.detailscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pucuk.binar_challenge_ch_5.R
import com.pucuk.binar_challenge_ch_5.databinding.FragmentDetailBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentHomeBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentSplashBinding
import com.pucuk.binar_challenge_ch_5.ui.splashscreen.SplashViewModel

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    lateinit var _binding: FragmentDetailBinding
    val splashVM: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return _binding.root

    }

}