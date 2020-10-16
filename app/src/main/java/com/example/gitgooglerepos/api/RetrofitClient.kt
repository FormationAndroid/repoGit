package com.example.gitgooglerepos.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.github.com/"

val retrofitClient: StackService by lazy {
        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    return@lazy retrofitBuilder.create(StackService::class.java)
}