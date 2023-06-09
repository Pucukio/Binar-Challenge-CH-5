package com.pucuk.binar_challenge_ch_5.ui.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pucuk.binar_challenge_ch_5.data.model.ResponseFilm
import com.pucuk.binar_challenge_ch_5.data.network.RetrofitClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _movie = MutableLiveData<ResponseFilm>()
    val movie: LiveData<ResponseFilm> = _movie

    private val _user = MutableLiveData<FirebaseUser?>()
    val user: LiveData<FirebaseUser?> = _user

    fun getFilm() = viewModelScope.launch {
        _movie.postValue(RetrofitClient.instance.getAllFilmPopular())
    }

    fun session() {
        if (Firebase.auth.currentUser != null) {
            _user.postValue(Firebase.auth.currentUser)
        } else {
            _user.postValue(null)
        }
    }
}