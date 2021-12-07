package com.example.newspaper.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    lateinit var api: RetrofitInterface
    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        var retrofit = Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/1360000/AsosDalyInfoService/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        api = retrofit.create(RetrofitInterface::class.java)
    }
}