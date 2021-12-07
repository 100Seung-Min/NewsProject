package com.example.newspaper.Retrofit

import com.example.newspaper.DTO.WeatherData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RetrofitInterface {
    @GET("getWthrDataList")
    fun getWeather(
        @Query("serviceKey") key: String = "QEy5RYWbj8QKaqIFxZhS0elVK6Bwvh5gb7LJ2HOWcYQ9wHOQbgL0LLyzgHYoykTrg3wRiPtLhdOjEZGUkJvD6g==",
        @Query("numOfRows") pageResult: Int,
        @Query("pageNo") pageNumber: Int,
        @Query("dataCd") pageCode: String,
        @Query("dateCd") dateCode: String,
        @Query("startDt") startDay: String,
        @Query("endDt") endDay: String,
        @Query("stnIds") cityNumber: Int,
        @Query("dataType") dataType: String = "Json"
    ): Call<WeatherData>
}