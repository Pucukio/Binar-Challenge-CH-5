package com.pucuk.binar_challenge_ch_5.ui.detailscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pucuk.binar_challenge_ch_5.data.model.ResponseDetailFilm
import com.pucuk.binar_challenge_ch_5.data.model.ResponseFilm
import com.pucuk.binar_challenge_ch_5.data.network.RetrofitClient
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _movie = MutableLiveData<ResponseDetailFilm>()
    val movie: LiveData<ResponseDetailFilm> = _movie
    fun getFilm(movieId: Int) = viewModelScope.launch {
        _movie.postValue(RetrofitClient.instance.getDetailFilm(movieId))
    }
}