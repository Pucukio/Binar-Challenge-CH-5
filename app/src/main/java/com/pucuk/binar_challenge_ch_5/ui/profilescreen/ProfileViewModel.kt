package com.pucuk.binar_challenge_ch_5.ui.profilescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileViewModel : ViewModel() {
    private val user = MutableLiveData<FirebaseUser?>()
    val account: LiveData<FirebaseUser?> = user

    private val _update = MutableLiveData<String?>()
    val update: LiveData<String?> = _update

    fun session() {
        if (Firebase.auth.currentUser != null) {
            user.postValue(Firebase.auth.currentUser)
        } else {
            user.postValue(null)
        }
    }

    fun updateEmail(email: String) =
        Firebase.auth.currentUser?.updateEmail(email)?.addOnCompleteListener {
            if (it.isSuccessful) {
                _update.postValue("Update Success!")
            } else {
                _update.postValue(it.exception.toString())
            }
        }

}