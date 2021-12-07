package com.example.newspaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.newspaper.DTO.WeatherData
import com.example.newspaper.Retrofit.RetrofitClient
import com.example.newspaper.databinding.ActivityMainBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val day = (SimpleDateFormat("yyyyMMdd").format(Date()).toInt() - 1).toString()
        RetrofitClient.api.getWeather(pageResult = 10, pageNumber = 1, pageCode = "ASOS", dateCode = "DAY", startDay = day, endDay = day, cityNumber = 108).enqueue(object : Callback<WeatherData>{
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                println("여기 ${response.body()!!.response.body.items.item[0].stnNm}")
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                println("여기 에러 ${t}")
            }
        })
    }
}