package com.pucuk.binar_challenge_ch_5.ui.detailscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.pucuk.binar_challenge_ch_5.R
import com.pucuk.binar_challenge_ch_5.databinding.FragmentDetailBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentHomeBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentSplashBinding
import com.pucuk.binar_challenge_ch_5.ui.splashscreen.SplashViewModel

class DetailFragment : Fragment() {

    private  val viewModel: DetailViewModel by viewModels()
    lateinit var _binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFilm(arguments?.getInt("MOVIE_ID")!!)
        bind()
    }
    private fun bind() {
        viewModel.movie.observe(viewLifecycleOwner){
            val imageUrl = "https://image.tmdb.org/t/p/w500"
            Glide.with(requireContext()).load(imageUrl + it.posterPath).into(_binding.ivDetail)
            _binding.tvTitle.text = it.title
//            _binding.tvDate.text = it.releaseDate
//            _binding.tvGenres.text = it.genres.toString()

        }
    }

}