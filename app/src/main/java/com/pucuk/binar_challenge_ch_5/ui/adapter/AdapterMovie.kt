package com.pucuk.binar_challenge_ch_5.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pucuk.binar_challenge_ch_5.data.model.ResponseDataFilmItem
import com.pucuk.binar_challenge_ch_5.databinding.ItemListBinding

class AdapterMovie(private val listNews: List<ResponseDataFilmItem>) : RecyclerView.Adapter<AdapterMovie.ViewHolder>()  {
    class ViewHolder(private val _binding: ItemListBinding) : RecyclerView.ViewHolder(_binding.root) {
        fun bind(filmItem: ResponseDataFilmItem, context: Context) {
            _binding.tvTitle.text = filmItem.title
            _binding.tvDescription.text = filmItem.releaseDate

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}