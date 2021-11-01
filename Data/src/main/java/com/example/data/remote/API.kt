package com.example.data.remote

import com.example.data.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("/{user-id}")
    fun getUser(@Path("user-id")userID:String): Single<User>
    @GET ("/{user-id}/media")
    fun getHomePostList(@Path("user-id")userID:String): Single<User>

}