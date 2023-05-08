package com.pucuk.binar_challenge_ch_5.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pucuk.binar_challenge_ch_5.data.model.Result
import com.pucuk.binar_challenge_ch_5.databinding.ItemListBinding

class AdapterMovie(private val listResult: List<Result>) : RecyclerView.Adapter<AdapterMovie.ViewHolder>()  {
    class ViewHolder(private val _binding: ItemListBinding) : RecyclerView.ViewHolder(_binding.root) {
        fun bind(filmItem: Result) {
            val imageUrl = "https://image.tmdb.org/t/p/w500"
            _binding.tvTitle.text = filmItem.title
            _binding.tvDate.text = filmItem.releaseDate
            Glide.with(itemView).load(imageUrl + filmItem.posterPath).into(_binding.ivImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = listResult.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(listResult[position])
}