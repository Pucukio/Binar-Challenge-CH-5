package com.pucuk.binar_challenge_ch_5.ui.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pucuk.binar_challenge_ch_5.data.model.ResponseFilm
import com.pucuk.binar_challenge_ch_5.data.network.RetrofitClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _movie = MutableLiveData<ResponseFilm>()
    val movie: LiveData<ResponseFilm> = _movie

    fun getFilm() = viewModelScope.launch {
        _movie.postValue(RetrofitClient.instance.getDetailFilm())
    }
}