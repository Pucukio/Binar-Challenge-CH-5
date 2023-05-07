package com.pucuk.binar_challenge_ch_5.data.dao

import retrofit2.http.Query


interface UserDao {
    @Query("SELECT COUNT(*) FROM user WHERE username = :username")
    suspend fun isUsernameExists(username: String): Int
}