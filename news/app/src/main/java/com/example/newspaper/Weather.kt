package com.example.newspaper

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jsoup.Jsoup

class Weather: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather)

        doAsync {
            val doc = Jsoup.connect("https://weather.naver.com/"). get()
            val temperature = doc.select("strong.current").text()
            val other = doc.select("dl.summary_list").text()
            val mise = doc.select("div.ttl_area").text()
            val print_t = findViewById<TextView>(R.id.temperate)
            val print_o = findViewById<TextView>(R.id.other)
            val print_m = findViewById<TextView>(R.id.wind)
            print_t.setText(temperature)
            print_o.setText(other)
            print_m.setText(mise)
        }

        val home = findViewById<ImageView>(R.id.home)
        home.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        val news = findViewById<ImageView>(R.id.news)
        news.setOnClickListener(){
            val intent = Intent(this, News::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        val weather = findViewById<ImageView>(R.id.weather)
        weather.setOnClickListener(){
            val intent = Intent(this, Weather::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
    }
}