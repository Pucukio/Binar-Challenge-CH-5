package com.pucuk.binar_challenge_ch_5.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pucuk.binar_challenge_ch_5.R
import com.pucuk.binar_challenge_ch_5.databinding.FragmentHomeBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentLoginBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentSplashBinding
import com.pucuk.binar_challenge_ch_5.ui.splashscreen.SplashViewModel


class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    lateinit var _binding: FragmentHomeBinding
    val splashVM: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

}