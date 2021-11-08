package com.example.data.remote

import com.example.data.User
import com.example.data.response.UserMediaResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("/{user-id}")
    fun getUser(@Path("user-id") userID: String): Single<User>

    @GET("/{user-id}/media")
    fun getHomePostList(@Path("user-id") userID: String): Single<User>

    @GET("/{user-id}")
    fun getUserMedia(
        @Path("user-id") userID: String,
        @Query("access_token") accessToken: String
    ): Single<UserMediaResponse>

    @GET("/oauth/authorize")
    fun instagramAuth(
        @Query("client_id") clientID: String,
        @Query("redirect_uri") redirectURI: String,
        @Query("response_type")responseType:String,
        @Query("scope")permissions:String
    ):Single<String>

}