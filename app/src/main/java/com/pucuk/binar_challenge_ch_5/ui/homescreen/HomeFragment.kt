package com.pucuk.binar_challenge_ch_5.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pucuk.binar_challenge_ch_5.R
import com.pucuk.binar_challenge_ch_5.databinding.FragmentHomeBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentLoginBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentSplashBinding
import com.pucuk.binar_challenge_ch_5.ui.adapter.AdapterMovie
import com.pucuk.binar_challenge_ch_5.ui.splashscreen.SplashViewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    lateinit var _binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFilm()
        viewModel.movie.observe(viewLifecycleOwner) {
            _binding.rvFilm.apply {
                adapter = AdapterMovie(it.results)
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }
        _binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.about -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                    true
                }
                R.id.logout -> {
                    Firebase.auth.signOut()
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}