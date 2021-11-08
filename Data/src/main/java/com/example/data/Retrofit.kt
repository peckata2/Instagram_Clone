package com.example.data

import com.example.data.remote.API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
        private val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        fun create(baseurl: String): API {
            return Retrofit.Builder()
                .baseUrl(baseurl)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(API::class.java)
        }
}