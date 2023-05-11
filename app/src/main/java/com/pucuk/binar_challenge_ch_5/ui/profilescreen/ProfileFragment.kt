package com.pucuk.binar_challenge_ch_5.ui.profilescreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pucuk.binar_challenge_ch_5.R
import com.pucuk.binar_challenge_ch_5.databinding.FragmentProfileBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentRegisterBinding
import com.pucuk.binar_challenge_ch_5.databinding.FragmentSplashBinding
import com.pucuk.binar_challenge_ch_5.ui.splashscreen.SplashViewModel

class ProfileFragment : Fragment() {

    private  val viewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.session()

        binding.apply {
            btnUpdate.setOnClickListener {
                val email = _binding.etEmail.text.toString().trim()
                val namaLengkap = _binding.etNamaLengkap.text.toString().trim()
                val tanggalLahir = _binding.etTanggalLahir.text.toString().trim()
                viewModel.updateEmail(email)
                viewModel.update.observe(viewLifecycleOwner) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.profileFragment)
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}